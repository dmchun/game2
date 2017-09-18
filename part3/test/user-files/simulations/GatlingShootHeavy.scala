package cloudinggame

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
import com.typesafe.config._
import scala.util.Random

class GatlingShootHeavy extends Simulation {

  val maxUser=1000

  val baseUrl = sys.env("SHOOT_BASE_URL")

  val httpConf = http
    .baseURL(baseUrl)
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0")

  val feeder = Iterator.continually(Map("name" -> ("name-"+Random.alphanumeric.take(maxUser).mkString)))

  val scn = scenario("GatlingShoot")
    .feed(feeder)
    .exec(http("request_on_hello")
      .get("/hello/${name}")
      .check(bodyString.is("This is hello for ${name}!")))

  setUp(
    scn.inject(constantUsersPerSec(maxUser) during(30 minutes))).throttle(
      reachRps(maxUser) in (30 seconds),
      holdFor(2 minutes),
      jumpToRps(maxUser*2),
      holdFor(2 minutes)
    ).maxDuration(5 minutes).protocols(httpConf)
}
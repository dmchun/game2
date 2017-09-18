package cloudinggame

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
import com.typesafe.config._
import scala.util.Random

class GatlingVerifyDyn extends Simulation {

  val baseUrl = sys.env("SHOOT_BASE_URL")

  val httpConf = http
    .baseURL(baseUrl)
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0")

  val scn = scenario("GatlingShoot")
    .exec(http("request_on_hello")
      .get("/hello/testname")
      .check(bodyString.is("This is hello for testname!")))

  setUp(
    scn.inject(atOnceUsers(1))).protocols(httpConf)
}
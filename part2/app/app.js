const express = require('express')
const app = express()

app.get('/', function (req, res) {
  res.status(200)
  res.setHeader('Content-Type','text/plain')
  res.send('This is hello from Clouding Game!')
})

app.get('/hello/:name', function (req, res) {
  res.status(200)
  res.setHeader('Content-Type','text/plain')
  var name = req.params.name
  res.send(`This is hello for ${name}!`)
})

app.listen(8080, function () {
  console.log('Example app listening on port 8080!')
})
const express = require('express')
const app = express()

app.get('/', function (req, res) {
  res.status(200)
  res.setHeader('Content-Type','text/plain')
  res.send('This is hello from Clouding Game!')
})

app.listen(8080, function () {
  console.log('Example app listening on port 8080!')
})
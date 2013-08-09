<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>URL shortener for BuddyBounce</title>
</head>

<body>
${message}
<br/><br/>

<div style="color: #666666;font-style: italic">
  <h4>Example</h4>
  Make a call like<br/>
  <g:createLink controller="URLToken" action="shortenURL" absolute="true"/>?urlToShort=http://www.cnn.com
  <br/><br/>
  In response you will get something like:<br/>
  <g:createLink controller="URLToken" action="index" params="[shortURL:'ccxuM']" absolute="true"/>
</div>
</body>
</html>
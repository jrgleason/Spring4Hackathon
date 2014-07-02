<!DOCTYPE HTML>
<html>
<%@ include file="head.jsp" %>
<body>
<%@ include file="navbar.jsp" %>
<div id="container">

    <div id="basic-template">
        <a class="ui-notify-cross ui-notify-close" href="#">x</a>
        <h1>&#35;{title}</h1>
        <p>&#35;{title}</p>
    </div>

</div>
<div class="container main_area">
    <noscript><h2 style="color: #ff0000">Seems your browser doesn't support Javascript! Websocket relies on Javascript
        being enabled. Please enable
        Javascript and reload this page!</h2></noscript>
    <div class="row container">
        <div class="col-sm-4">
            <div class="disconnected status">
                <i class="fa fa-square"></i> Server is currently disconnected
            </div>
            <div class="connected status">
                <i class="fa fa-square"></i> Server is currently connected
            </div>
        </div>
    </div>
    <div id="conversationDiv" class="row row_pad connected">
        <div class="container">
            <div class="col-sm-4">
                <label>Welcome Please Type Your Message</label>
            </div>
            <div class="col-sm-5">
                <div class="row">
                    <label for="title">Title</label>
                    <input type="text" id="title"/>
                </div>
                <div class="row">
                    <label for="text">Text</label>
                    <input type="text" id="text"/>
                </div>
                <div class="row">
                    <button id="sendName" onclick="sendName();">Send</button>
                </div>
            </div>
        </div>
    </div>
    <div class="row row_pad container">
        <div class="well">
            <p id="response"></p>
        </div>
    </div>
</div>
<%@ include file="foot.jsp" %>
</body>
</html>
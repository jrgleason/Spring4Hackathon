<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">WebSocket Chat</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul  class="nav navbar-nav">
                <li class="active">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Chat<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li class="disconnected"><a href="#" onclick="connect();">Connect</a></li>
                        <li class="connected"><a href="#" onclick="disconnect();">Disconnect</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
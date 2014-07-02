var stompClient = null;

$(function() {
//    $(".connected").toggle("fade");
    $("#container").notify({
        speed: 500,
        expires: false
    });
});

function setConnected(connected) {
    $(".connected").toggle("fade");
    $(".disconnected").toggle("fade");
//    document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
//    document.getElementById('response').innerHTML = '';
}

function connect() {
    var socket = new SockJS('/alert');
    stompClient = Stomp.over(socket);
    stompClient.heartbeat.outgoing = 0;
    stompClient.heartbeat.incoming = 0;
    stompClient.connect({}, function(frame) {
        setConnected();
        stompClient.subscribe('/topic/alert', function(greeting){
            showGreeting(JSON.parse(greeting.body).content);
        });
    });
    socket.onclose = function() {
        stompClient.disconnect();
        setConnected();
    };
}
function connectOneWay() {
    var socket = new SockJS('/alert');
    stompClient = Stomp.over(socket);
    stompClient.heartbeat.outgoing = 0;
    stompClient.heartbeat.incoming = 0;
    stompClient.connect({}, function(frame) {
        setConnected();
    });
    socket.onclose = function() {
        stompClient.disconnect();
        setConnected();
    };
}

function disconnect() {
    stompClient.disconnect();
    setConnected();
}

function sendName() {
    var title = document.getElementById('title').value;
    var text = document.getElementById('text').value;
    stompClient.send("/app/alert", {}, JSON.stringify({ 'title': title, 'text': text }));
}

function showGreeting(message) {
    var obj = JSON.parse(message);
    console.log(obj.title);
    $("#container").notify("create", {
        title: obj.title,
        text: obj.text
    });
}
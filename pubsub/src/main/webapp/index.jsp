<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Pub/Sub Subscriber</title>
    <script>
        var ws = new WebSocket("ws://localhost:8088/pubsub");

        ws.onmessage = function(event) {
            var messages = document.getElementById("messages");
            var newMessage = document.createElement("li");
            newMessage.textContent = event.data;
            messages.appendChild(newMessage);
        };

        ws.onopen = function() {
            console.log("Connected to WebSocket server.");
        };

        ws.onclose = function() {
            console.log("Disconnected from WebSocket server.");
        };
    </script>
</head>
<body>
    <h2>메시지 구독</h2>
    <ul id="messages"></ul>
    <a href="publish.jsp">메시지 발행하기</a>
</body>
</html>

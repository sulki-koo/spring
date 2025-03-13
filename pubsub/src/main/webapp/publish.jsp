<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>메시지 발행</title>
    <script>
        var ws = new WebSocket("ws://localhost:8088/pubsub");

        function sendMessage() {
            var message = document.getElementById("messageInput").value;
            ws.send(message);
            document.getElementById("messageInput").value = "";
        }
    </script>
</head>
<body>
    <h2>메시지 발행</h2>
    <input type="text" id="messageInput" placeholder="메시지를 입력하세요">
    <button onclick="sendMessage()">발행</button>
    <br><br>
    <a href="index.jsp">구독 페이지로 이동</a>
</body>
</html>
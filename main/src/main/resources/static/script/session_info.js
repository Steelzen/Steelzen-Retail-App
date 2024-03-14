const xhttp = new XMLHttpRequest();

xhttp.onload = function () {
    const sessionId = this.response;
    console.log(sessionId);

    document.getElementById("session-info").innerHTML = sessionId;

}

xhttp.open("GET", "/api/v1/cart/session_info");
xhttp.send();
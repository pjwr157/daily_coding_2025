window.onload = function () {
    var t = document.getElementById("a");

    var s = "";

    while (true) {

        s = prompt("값을 입력하세요 :");
        if (s == 100) {
            break;
        } else {
            t.innerHTML += "마지막 입력값:" + s + "<br>";
        }
    }

}

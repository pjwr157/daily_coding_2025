var horses = ["horse1", "horse2"];
var positions = [0, 0];

const finishLine = 800;
var race;

function run() {
    for (let i = 0; i < horses.length; i++) {
        const move = Math.random() * 10; // 랜덤 속도
        positions[i] += move;
        document.getElementById(horses[i]).style.left = positions[i] + "px";

        if (positions[i] >= finishLine) {
            clearInterval(race);
            // alert(horses[i] + "가 우승했습니다!");
            alert((i + 1)+ "번 말이 우승했습니다!");
        }
    }
}

function startRace() {
    race = setInterval(run, 100); // 0.1초마다 움직임
}

startRace();

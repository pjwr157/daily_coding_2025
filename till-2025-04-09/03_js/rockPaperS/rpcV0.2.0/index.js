/**********************************************************************
* 가위 바위 보 게임 (v0.2.0)
*
* - 가위바위보 기능
* - 유저 가위바위보 입력 시 예외처리 추가
**********************************************************************/

// Rock Paper Scissors
var userRpc = "";
while(true){    // while 무한루프 걸기는 이렇게 하면 됩니다
    userRpc = prompt("가위,바위,보 중에 하나를 입력하세요:");
    if(userRpc == "가위" || userRpc == "바위" || userRpc == "보"){
        break;  // while 무한루프를 빠져나감
    } else {
        alert("장난치지마세요");
    }
}


var comRpc = Math.floor(Math.random()*3+1);
if(comRpc == 1){
    comRpc = "가위";
}
if(comRpc == 2){
    comRpc = "바위";
}
if(comRpc == 3){
    comRpc = "보";
}


dw("유저:"+userRpc);
br();
dw("컴:"+comRpc);
br();

var winDrawLose = "";
switch(userRpc){
    case "가위":
        switch(comRpc){
            case "가위":
                winDrawLose = "DRAW";
                break;
            case "바위":
                winDrawLose = "패배";
                break;
            case "보":
                winDrawLose = "승리";
                break;
        }
        break;
    case "바위":
        switch(comRpc){
            case "가위":
                winDrawLose = "승리";
                break;
            case "바위":
                winDrawLose = "DRAW";
                break;
            case "보":
                winDrawLose = "패배";
                break;
        }        
        break;
    case "보":
        switch(comRpc){
            case "가위":
                winDrawLose = "패배";
                break;
            case "바위":
                winDrawLose = "승리";
                break;
            case "보":
                winDrawLose = "DW";
                break;
        }        
        break;
}

dw(winDrawLose);
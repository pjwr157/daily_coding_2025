/**********************************************************************
가위 바위 보 게임 (v0.4.0)

[기존 기능]
- 가위바위보 기능
- 유저 가위바위보 입력 시 예외처리 추가
- 유저 가위바위보 입력을 입력창에서 받도록 수정
v0.4.0 업데이트 내용
- 결과 출력 화면을 dw()가 아닌 출력화면용 textarea에 출력하도록 개선
(가위바위보 게임을 단판이 아닌 무한으로 가능해졌음)


todo:
**********************************************************************/
// t1.addEventListener('click', btn_listener);

// 선언
var userRpc = "";
var comRpc = "";

var rpcInputText;
var rpcResultScreen;

var resultString = "";

// ***** 중요 ******
window.onload = function(){

    rpcInputText = document.getElementById("rpc_input_text");       // 연결
    rpcResultScreen = document.getElementById("rpc_result_screen");       // 연결
    
}

function rpcInputButtonClick(){
    resultString = "";  //결과 화면 초기화
    rpcResultScreen.value = resultString;   // 텍스트 에어리어 지움

    // userRpc = prompt("가위,바위,보 중에 하나를 입력하세요:");
    userRpc = rpcInputText.value;
    if(userRpc == "가위" || userRpc == "바위" || userRpc == "보"){  //정상 입력 검사. ok면 가위바위보 로직을 처리
        ////    가위바위보 로직을 처리  ////
        comRpc = Math.floor(Math.random()*3+1); // 컴퓨터 난수 발생 시키기 (1~3)
        if(comRpc == 1){
            comRpc = "가위";
        }
        if(comRpc == 2){
            comRpc = "바위";
        }
        if(comRpc == 3){
            comRpc = "보";
        }
    
        
        // dw("유저:"+userRpc);
    
        resultString = resultString + "유저:"+userRpc;
        
        // br();
        resultString = resultString + "\n";
        
        // dw("컴:"+comRpc);    
        resultString = resultString + "컴:"+comRpc;
        
        // br();
        resultString = resultString + "\n";
    
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
        // dw(winDrawLose);    
        resultString = resultString + "결과: " + winDrawLose;
        // 결과 출력
        rpcResultScreen.value = resultString;
    } else {
        alert("장난치지마세요");
        return;
    }
}
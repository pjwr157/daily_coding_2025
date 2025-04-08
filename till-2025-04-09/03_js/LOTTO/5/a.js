// 2. 내가 한 게임을 구매했다고 가정하고		

// 컴퓨터의 6개의 숫자랑 내꺼랑 비교해서 몇개가 일치하는 지 세어 출력하기					 ex. 3개 일치	


// 내 번호들
var p1 = 1;
var p2 = 2;
var p3 = 3;
var p4 = 4;
var p5 = 5;
var p6 = 6;
var p = "내 번호: " + p1 + "," + p2 + "," + p3 + "," + p4 + "," + p5 + "," + p6;
dw(p);
hr();
// 컴 번호들
var r1,r2,r3,r4,r5,r6;

// 랜덤 번호들
r1 = Math.floor(Math.random() * 45) + 1; // 1 ~ n 까지 범위내에서 랜덤하게 숫자 하나 뽑아주는 애.
document.write(r1);
document.write("<br>");


////    앞선 번호들과 비교하여 중복된 번호가 나온 경우 다시 번호를 뽑게 하기(그렇게 해서 나온 번호도 또 검사를 계속 해야함)
while(true){

    r2 = Math.floor(Math.random() * 45) + 1; // 1 ~ n 까지 범위내에서 랜덤하게 숫자 하나 뽑아주는 애.

    if(r1 != r2){   // r2가 r1과 같지 않으면 빠져나감
        document.write(r2);
        document.write("<br>");
        break;
    }
}

////    중복제거


//todo r3  가 r1 이나 r2와 같으면 다시뽑게하기(무한히)
while(true){

    r3 = Math.floor(Math.random() * 45) + 1; // 1 ~ n 까지 범위내에서 랜덤하게 숫자 하나 뽑아주는 애.

    //case 1
    // if(r3 != r1 && r3 != r2 ){   // r3  가 r1 이나 r2와 같으면 다시뽑게하기(무한히)
    //     document.write(r3);
    //     document.write("<br>");
    //     break;
    // }

    //case 2
    if(r3 != r1){   // r3  가 r1 이나 r2와 같으면 다시뽑게하기(무한히)
        if(r3 != r2){
            document.write(r3);
            document.write("<br>");
            break;
        }
    }
}




var r4 = Math.floor(Math.random() * 45) + 1; // 1 ~ n 까지 범위내에서 랜덤하게 숫자 하나 뽑아주는 애.
document.write(r4);
document.write("<br>");

var r5 = Math.floor(Math.random() * 45) + 1; // 1 ~ n 까지 범위내에서 랜덤하게 숫자 하나 뽑아주는 애.
document.write(r5);
document.write("<br>");

var r6 = Math.floor(Math.random() * 45) + 1; // 1 ~ n 까지 범위내에서 랜덤하게 숫자 하나 뽑아주는 애.
document.write(r6);
document.write("<br>");



//todo:
// 컴퓨터의 6개의 숫자랑 내꺼랑 비교해서 몇개가 일치하는 지 세어 출력하기					 ex. 3개 일치	
// p1 ~ p6


var win = 0;    //내가 맞춘 수

if(p1 == r1){
    win = win + 1;
}
if(p1 == r2){
    win = win + 1;
}
if(p1 == r3){
    win = win + 1;
}
if(p1 == r4){
    win = win + 1;
}
if(p1 == r5){
    win = win + 1;
}
if(p1 == r6){
    win = win + 1;
}

if(p2 == r1){
    win = win + 1;
}
if(p2 == r2){
    win = win + 1;
}
if(p2 == r3){
    win = win + 1;
}
if(p2 == r4){
    win = win + 1;
}
if(p2 == r5){
    win = win + 1;
}
if(p2 == r6){
    win = win + 1;
}

//3

if(p3 == r1){
    win = win + 1;
}
if(p3 == r2){
    win = win + 1;
}
if(p3 == r3){
    win = win + 1;
}
if(p3 == r4){
    win = win + 1;
}
if(p3 == r5){
    win = win + 1;
}
if(p3 == r6){
    win = win + 1;
}

//4

if(p4 == r1){
    win = win + 1;
}
if(p4 == r2){
    win = win + 1;
}
if(p4 == r3){
    win = win + 1;
}
if(p4 == r4){
    win = win + 1;
}
if(p4 == r5){
    win = win + 1;
}
if(p4 == r6){
    win = win + 1;
}

//5

if(p5 == r1){
    win = win + 1;
}
if(p5 == r2){
    win = win + 1;
}
if(p5 == r3){
    win = win + 1;
}
if(p5 == r4){
    win = win + 1;
}
if(p5 == r5){
    win = win + 1;
}
if(p5 == r6){
    win = win + 1;
}

//6

if(p6 == r1){
    win = win + 1;
}
if(p6 == r2){
    win = win + 1;
}
if(p6 == r3){
    win = win + 1;
}
if(p6 == r4){
    win = win + 1;
}
if(p6 == r5){
    win = win + 1;
}
if(p6 == r6){
    win = win + 1;
}

document.write("win:"+win);



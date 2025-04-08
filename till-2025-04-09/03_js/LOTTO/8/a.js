// 2. 내가 한 게임을 구매했다고 가정하고		

// 컴퓨터의 6개의 숫자랑 내꺼랑 비교해서 몇개가 일치하는 지 세어 출력하기					 ex. 3개 일치	


// 내 번호들
// var p1 = 1;
// var p2 = 2;
// var p3 = 3;
// var p4 = 4;
// var p5 = 5;
// var p6 = 6;

// 내번호들 (기존 일반변수에서 배열로 바꾸기)
var p = [17,41,18,23,5,28];
dw(p); hr();

// 컴 번호들
// var r[0],r[1],r[2],r[3],r[4],r[5];

var r = [0,0,0,0,0,0];



// 랜덤 번호들
r[0] = Math.floor(Math.random() * 45) + 1; // 1 ~ n 까지 범위내에서 랜덤하게 숫자 하나 뽑아주는 애.
document.write(r[0]);
document.write("<br>");


////    앞선 번호들과 비교하여 중복된 번호가 나온 경우 다시 번호를 뽑게 하기(그렇게 해서 나온 번호도 또 검사를 계속 해야함)
while(true){

    r[1] = Math.floor(Math.random() * 45) + 1; // 1 ~ n 까지 범위내에서 랜덤하게 숫자 하나 뽑아주는 애.

    if(r[0] != r[1]){   // r[1]가 r[0]과 같지 않으면 빠져나감
        document.write(r[1]);
        document.write("<br>");
        break;
    }
}


// r[2]  가 r[0] 이나 r[1]와 같으면 다시뽑게하기(무한히)
while(true){

    r[2] = Math.floor(Math.random() * 45) + 1; // 1 ~ n 까지 범위내에서 랜덤하게 숫자 하나 뽑아주는 애.

    if(r[2] != r[0] && r[2] != r[1] ){   // r[2]  가 r[0] 이나 r[1]와 같으면 다시뽑게하기(무한히)
        document.write(r[2]);
        document.write("<br>");
        break;
    }
}




while(true){

    r[3] = Math.floor(Math.random() * 45) + 1; // 1 ~ n 까지 범위내에서 랜덤하게 숫자 하나 뽑아주는 애.

    if(r[3] != r[0] && r[3] != r[1] && r[3] != r[2]){
        document.write(r[3]);
        document.write("<br>");
        break;
    }
}



while(true){

    r[4] = Math.floor(Math.random() * 45) + 1; // 1 ~ n 까지 범위내에서 랜덤하게 숫자 하나 뽑아주는 애.

    if(r[4] != r[0] && r[4] != r[1] && r[4] != r[2] && r[4] != r[3]){
        document.write(r[4]);
        document.write("<br>");
        break;
    }
}



while(true){

    r[5] = Math.floor(Math.random() * 45) + 1; // 1 ~ n 까지 범위내에서 랜덤하게 숫자 하나 뽑아주는 애.

    if(r[5] != r[0] && r[5] != r[1] && r[5] != r[2] && r[5] != r[3] && r[5] != r[4]){
        document.write(r[5]);
        document.write("<br>");
        break;
    }
}



// 컴퓨터의 6개의 숫자랑 내꺼랑 비교해서 몇개가 일치하는 지 세어 출력하기					 ex. 3개 일치	
// p1 ~ p6


var win = 0;    //내가 맞춘 수

if(p[0] == r[0]){
    win = win + 1;
}
if(p[0] == r[1]){
    win = win + 1;
}
if(p[0] == r[2]){
    win = win + 1;
}
if(p[0] == r[3]){
    win = win + 1;
}
if(p[0] == r[4]){
    win = win + 1;
}
if(p[0] == r[5]){
    win = win + 1;
}

if(p[1] == r[0]){
    win = win + 1;
}
if(p[1] == r[1]){
    win = win + 1;
}
if(p[1] == r[2]){
    win = win + 1;
}
if(p[1] == r[3]){
    win = win + 1;
}
if(p[1] == r[4]){
    win = win + 1;
}
if(p[1] == r[5]){
    win = win + 1;
}

//3

if(p[2] == r[0]){
    win = win + 1;
}
if(p[2] == r[1]){
    win = win + 1;
}
if(p[2] == r[2]){
    win = win + 1;
}
if(p[2] == r[3]){
    win = win + 1;
}
if(p[2] == r[4]){
    win = win + 1;
}
if(p[2] == r[5]){
    win = win + 1;
}

//4

if(p[3] == r[0]){
    win = win + 1;
}
if(p[3] == r[1]){
    win = win + 1;
}
if(p[3] == r[2]){
    win = win + 1;
}
if(p[3] == r[3]){
    win = win + 1;
}
if(p[3] == r[4]){
    win = win + 1;
}
if(p[3] == r[5]){
    win = win + 1;
}

//5

if(p[4] == r[0]){
    win = win + 1;
}
if(p[4] == r[1]){
    win = win + 1;
}
if(p[4] == r[2]){
    win = win + 1;
}
if(p[4] == r[3]){
    win = win + 1;
}
if(p[4] == r[4]){
    win = win + 1;
}
if(p[4] == r[5]){
    win = win + 1;
}

//6

if(p[5] == r[0]){
    win = win + 1;
}
if(p[5] == r[1]){
    win = win + 1;
}
if(p[5] == r[2]){
    win = win + 1;
}
if(p[5] == r[3]){
    win = win + 1;
}
if(p[5] == r[4]){
    win = win + 1;
}
if(p[5] == r[5]){
    win = win + 1;
}

document.write("win:"+win);



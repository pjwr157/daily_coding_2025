// 문8	조건문	switch	사용	랜덤 1~6	숫자를 뽑고	각 숫자가 나올 때 각 숫자에 맞는 주사위 이미지로 화면에 출력
var r = Math.floor(Math.random() * 6) + 1;
switch(r){
    case 1:
        document.write("<img src='dice6_1.jpg'>");
        document.write("<hr>");
        break;
    case 2:
        document.write("<img src='dice6_2.jpg'");
        break;
    case 3:
        document.write("<img src='dice6_3.jpg'>");
        break;
    case 4:
        document.write("<img src='dice6_4.jpg'>");
        break;
    case 5:
        document.write("<img src='dice6_5.jpg'>");
        break;
    case 6:
        document.write("<img src='dice6_6.jpg'>");
        break;
}

document.write("<img src='dice6_" + (Math.floor(Math.random() * 6) + 1) + ".jpg'>");
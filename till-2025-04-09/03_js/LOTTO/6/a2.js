var p1 = 1
var p2 = 2
var p3 = 3
var p4 = 4
var p5 = 5
var p6 = 6
var p = "내가 고른 넘버: " + p1 + "," + p2 + "," + p3 + "," + p4 + "," + p5 + "," + p6
dw(p); hr();

var c1; var c2; var c3; var c4; var c5; var c6;

c1 = Math.floor(Math.random() * 45) +1
dw(c1); br();

while(true){
    c2 = Math.floor(Math.random() * 45) +1
    if(c2 != c1){
        dw(c2); br();
        break;
    }
}
while(true){
    c3 = Math.floor(Math.random() * 45) +1
    if(c3 != c1 && c3 != c2){
        dw(c3); br();
        break;
    }
}
while(true){
    c4 = Math.floor(Math.random() * 45) +1
    if(c4 != c1 && c4 != c2 && c4 != c3){
        dw(c4); br();
        break;
    }
}
while(true){
    c5 = Math.floor(Math.random() * 45) +1
    if(c5 != c1 && c5 != c2 && c5 != c3 && c5 != c4){
        dw(c5); br();
        break;
    }
}
while(true){
    c6 = Math.floor(Math.random() * 45) +1
    if(c6 != c1 && c6 != c2 && c6 != c3 && c6 != c4 && c6 != c5){
        dw(c6); br();
        break;
    }
}

var win = 0

if(p1 == c1){
    win++;
}
if(p1 == c2){
    win++;
}
if(p1 == c3){
    win++;
}
if(p1 == c4){
    win++;
}
if(p1 == c5){
    win++;
}
if(p1 == c6){
    win++;
}

if(p2 == c1){
    win++;
}
if(p2 == c2){
    win++;
}
if(p2 == c3){
    win++;
}
if(p2 == c4){
    win++;
}
if(p2 == c5){
    win++;
}
if(p2 == c6){
    win++;
}
if(p3 == c1){
    win++;
}
if(p3 == c2){
    win++;
}
if(p3 == c3){
    win++;
}
if(p3 == c4){
    win++;
}
if(p3 == c5){
    win++;
}
if(p3 == c6){
    win++;
}
if(p4 == c1){
    win++;
}
if(p4 == c2){
    win++;
}
if(p4 == c3){
    win++;
}
if(p4 == c4){
    win++;
}
if(p4 == c5){
    win++;
}
if(p4 == c6){
    win++;
}
if(p5 == c1){
    win++;
}
if(p5 == c2){
    win++;
}
if(p5 == c3){
    win++;
}
if(p5 == c4){
    win++;
}
if(p5 == c5){
    win++;
}
if(p5 == c6){
    win++;
}
if(p6 == c1){
    win++;
}
if(p6 == c2){
    win++;
}
if(p6 == c3){
    win++;
}
if(p6 == c4){
    win++;
}
if(p6 == c5){
    win++;
}
if(p6 == c6){
    win++;
}

dw("맞춘 수...!?  " + win);
var i;
i = Math.floor(Math.random() * 3) + 1;
for(var x=1 ; x <= i ; x = x + 1 ){
    document.write("<img src='cat.jpg'>");
}

// 내가 만든거
// By Sensei

var random;
random = Math.floor(Math.random() * 3) + 1; // 1 ~ n 까지 범위내에서 랜덤하게 숫자 하나 뽑아주는 애.

for(var i=1 ; i <= random ; i = i + 1 ){
    document.write("<img src='cat.jpg'>");
}
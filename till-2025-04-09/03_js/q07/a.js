var random=Math.floor(Math.random()*100)+1;
for( var i=1;  i <= random;  i=i+1  ) {
    if ( i == 7 ) { //황금고양이 만들기
        document.write("<img id='goldcat' src='cat.jpg' width='100px' height='100px'>");
        document.write(i);
        var gold_cat_img = document.getElementById("goldcat");
        gold_cat_img.style.borderColor = "yellow";
        gold_cat_img.style.borderStyle = "solid";
        gold_cat_img.style.borderWidth = "10px";
    } else {
        document.write("<img src='cat.jpg' width='100px' height='100px'>");
        document.write(i);
    }
}

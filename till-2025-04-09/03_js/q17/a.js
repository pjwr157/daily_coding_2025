for (var i = 1; i <= 10; i = i + 1) {
    for (var j = 1; j <= 10; j = j + 1) {
        document.write("A");
    }
    document.write("<br>");
}

for (var i = 1; i <= 10; i = i + 1) {
    for (var j = 1; j <= i; j = j + 1) {
        document.write("A");
    }
    document.write("<br>");
}

for (var i = 1; i <= 10; i = i + 1) {
    for (var j = 10; j >= i; j = j - 1) {
        document.write("A");
    }
    document.write("<br>");
}

for(var i=1; i<=10; i=i+1){

    for(var k=1; k <= i - 1; k=k+1){
        document.write("&nbsp;")
    }

    for(var j=10; j>=i; j=j-1){
        document.write("*");
    }
    document.write("<br>");
}

for(var i=1; i<=10; i=i+1){

    for(k=9; k>=i; k=k-1){
        document.write("&nbsp;");
    }


    for(var j=1; j<=i; j=j+1){
        document.write("*");
    }
    document.write("<br>");
}
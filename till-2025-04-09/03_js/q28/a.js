function hr(){
    document.write("<hr>")
}

for(var i=1;i<=10;i=i+1){
    document.write(i);
    if(i%2 == 1){
        document.write("홀수입니다.");
    } else {
        document.write("짝수입니다.");
    }
    hr();
}
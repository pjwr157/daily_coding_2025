// 문16 case2		while	참고탭 참고	1~10 출력

window.onload = function(){

    var t = document.getElementById("a");


    var n = 0;  //변수 선언 및 초기화
    
    var s = "";
    
    while(true){

        n=n+1;
    
        if(n > 10){
            break;
        }else{
            s = s + n + "<hr>" + "<br>";
        }
    }
    
    t.innerHTML = s;

}

// var n=0;

// while(true){
//     n=n+1;
//     if(n>10){
//         break;
//     } else {
//         document.write(n);
//     }

// }
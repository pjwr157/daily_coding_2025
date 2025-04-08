// 문42	
//함수
//  	1	100을 리턴하는 함수 만들기	
// 		2	200을 리턴하는 함수 만들기	
// 		3	숫자 둘을 매개변수로 받아서 이 둘을 더하여 그 결과를 리턴하는 함수 만들기	
//
// 		4	3 함수의 첫번째 매개변수에 1번 함수를 넣고 
//              두번째 매개변수에 2번 함수를 넣은다음 3 함수가 실행되서 리턴 되는 값을 출력하기	

//함수

function cat(){
    return 100;
}

function cat2(){
    return 200;
}

function add_a_plus_b(a,b){

    // var zz = a + b;

    return a + b;
}

// 함수 실행
var y = add_a_plus_b( cat(), cat2() );

document.write(y);




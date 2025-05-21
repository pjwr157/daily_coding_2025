// 배열
//
// 1) 초깃값이 없는 경우    var numbers = new Array();		var numbers = new Array(4);	
// 2) 초깃값이 있는 경우    var numbers = ["one","two","three"];			var numbers = Array("one","two","three");

// 배열에서 값을 꺼내기
// ex. var a = Array("개","고양이","너굴맨");

// 개 꺼내기 > a[0]     << a 0 ?? 1 이 아니고?? ㅇㅅㅇ? 대괄호 [ ] 안에 있는 값을 인덱스 (index) 라고 하는데 이 인덱스의 시작은 우리 상식처럼 1 부터 시작이 아니라 0 부터다.
// 컴터는 숫자를 0부터 세는 경우가 많다. 그래서 개발자 직업병이 숫자 0부터 셈.



var a = new Array();
// 1. 1,2,3,4 숫자배열을 만들기
a = [1,2,3,4];

// 2.일반 변수 선언하고 2와 4를 배열값 꺼내서 더해서 변수에 넣기
var n1=a[1];
var n2=a[3];
var sum = n1 + n2;

// 3.alert 함수를 이용해서 이 변수값 출력
alert("합계: "+sum);




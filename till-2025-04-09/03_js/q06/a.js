// 문5	문4를 복사해서						
// 		문1의 랜덤을 이용	1 ~ 100	까지 변하는 변수를 하나 추가하기			
// 		이 랜덤 값을 반복문의 조건문에 넣어		1 ~ 랜덤수	까지 반복하게 수정		즉, 고양이가 1~100마리 랜덤하게 나오게 처리

// 문6	문5 복사	이미지 오른쪽에 각 번호 (1 .. 2 .. 3 ... ) 도 표시하기

var random;
random = Math.floor(Math.random() * 100) + 1; // 1 ~ n 까지 범위내에서 랜덤하게 숫자 하나 뽑아주는 애.

for(var i=1 ; i <= random ; i = i + 1 ){
    document.write("<img src='cat.jpg' border solid 1px pink>");
    document.write(i);
}
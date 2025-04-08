// var i = prompt("값을 입력하세요 :")
// if (i > 100) {
//     document.write("100보다 큽니다")
//     elif(i = 100){
//         document.write("100입니다")
//     }
//     else ("100이하입니다")
// }

// elif	❌ JavaScript엔 elif 없음! → else if로 써야 해요
// =	❌ =는 "대입"이고, 비교할 때는 == 또는 === 써야 해요
// else (조건)	❌ else는 조건 안 붙임 → 그냥 {} 써야 함

// var i = prompt("값을 입력하세요 :")
// if (i > 100) {
//     document.write("100보다 큽니다")
//     }else if(i == 100){
//         document.write("100입니다")
//     } else {
//         document.write("100이하입니다")
// }

var s = prompt("값을 입력하세요 :");
if (s > 100) {
    alert("100보다큼");
} else if (s < 100) {
    alert("100보다 작음");
} else {
    alert("100임");
}
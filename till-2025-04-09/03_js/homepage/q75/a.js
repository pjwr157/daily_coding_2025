function login(){
	var tagId = document.getElementById("id");
	var tagPw = document.getElementById("pw");

	var id = tagId.value;
	var pw = tagPw.value;

	console.log(id);
	console.log(pw);

	if(id=="cat" && pw=="1234"){
		alert("로그인 성공");
	} else {
		alert("로그인 실패");
	}
}
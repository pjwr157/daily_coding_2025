<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8"); // 이거 안하면 한글 깨짐.
	
	// *주의* 체크를 하나도 안하고 넘어오는 경우 nS[] 에 null 이 들어감.
	// 그래서 널체크 (널 예외처리를 해줘야함)	
	String nS[] = request.getParameterValues("hobby");
	//out.println(nS[0]);
	//out.println(nS[1]);

	// 	if(nS != null){		
	// 		for(int i=0;i<nS.length;i++){
	// 			out.println(nS[i]);
	// 		}
	// 	}
	%>

	<%
	if (nS != null) {
	%>

	사이즈:<%=nS.length%>

	<%
		for (int i = 0; i < nS.length; i++) {
	%>
	
		<%=nS[i]%>
		
	<%
		}
	}
	%>
</body>
</html>
<!-- 백업:페이징,검색,페이징블럭처리까지 한거 -->
<!-- 컨트롤러 적용하려고 일단 백업으로 뺏음 -->
<!-- 컨트롤러 적용 list에는 일단 가장 기초형태 리스트로 하려고 함(쉽게) -->
<%@page import="com.peisia.db.Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.peisia.db.Dto"%>
<%@page import="com.peisia.db.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
글번호, 제목, 작성자<hr>
<%
String pageNum=request.getParameter("page");
if(pageNum==null){
	pageNum="1";
}

Dao dao=new Dao();

int totalPage = 0;

ArrayList<Dto> posts = null;
String searchWord=request.getParameter("word");
if(searchWord==null||searchWord.equals("null")){	// case1. 검색어가 없으면
	posts=dao.list(pageNum);
	totalPage = dao.getTotalPageCount();	//총 페이지 수 구하기
}else{					// case2. 검색어가 있으면
	posts=dao.listSearch(searchWord,pageNum);
	totalPage = dao.getSearchTotalPageCount(searchWord);	//총 페이지 수 구하기
}

for(int i=0;i<posts.size();i=i+1){
%>

<%=posts.get(i).no%>
<a href="/board/read?no=<%=posts.get(i).no%>"><%=posts.get(i).title%></a>
<%=posts.get(i).id%>
<hr>
<%
}
%>
<a href="write.jsp">쓰기</a>


<hr><hr>
<%
	int nPageNum = Integer.parseInt(pageNum);	//계산을 위해 변환.

	//🐿️🐿️🐿️{블럭 처리 - 1/9}.블럭 총 갯수 구하기🐿️🐿️🐿️//
	//블럭이란? ex. [1][2][3][4][5] ... [6][7][8][9][10] << 이렇게 게시판 하단에 페이지 리스트들이 묶인 단위(1~5:1블럭, 6~10:2블럭)
	//블럭 총 갯수 = 페이지 수 / 블럭 당 페이지 수 << 결과에 올림 처리
	int totalBlock = (int)Math.ceil((double) totalPage / Board.PAGE_LINK_AMOUNT);	
	
	//🐿️🐿️🐿️{블럭 처리 - 2/9}.현재 블럭 번호 구하기🐿️🐿️🐿️//
	//현재 블럭 번호 = 현재 페이지 번호 / 블럭 당 페이지 수 << 결과에 올림 처리
	int currentBlockNo = (int)Math.ceil((double)nPageNum / Board.PAGE_LINK_AMOUNT);

	//🐿️🐿️🐿️{블럭 처리 - 3/9}.블럭 시작 페이지 번호 구하기🐿️🐿️🐿️//
	//블럭 시작 페이지 번호 = (현재 블럭 번호 - 1) * 블럭 당 페이지 수 + 1
	int	blockStartNo = (currentBlockNo - 1) * Board.PAGE_LINK_AMOUNT + 1;

	//🐿️🐿️🐿️{블럭 처리 - 4/9}.블럭 페이지 끝 번호 구하기🐿️🐿️🐿️//
	//블럭 페이지 끝 번호 = 현재 블럭 번호 * 블럭 당 페이지 수
	int blockEndNo = currentBlockNo * Board.PAGE_LINK_AMOUNT;
	//만약 블럭 마지막 페이지 번호가 전체 페이지 마지막 번호보다 큰경우에는 블럭 마지막 페이지번호를 페이지 마지막 번호로 저장하는 예외 처리 하기
	if(blockEndNo > totalPage) {
		blockEndNo = totalPage;
	}
	
	//🐿️🐿️🐿️{블럭 처리 - 5/9}.이전 다음 처리🐿️🐿️🐿️ 
	//🐿️🐿️🐿️: 현재 블럭에서 이전/다음을 눌렀을 때 현재 페이지 값을 변경할 때 넣을 값을 일단 초기화하기🐿️🐿️🐿️//
	//이전 다음이란? ex.    <이전 [1][2][3][4][5] 다음> <<요런거
	int prevPage = 0;
	int nextPage = 0;
	
	//🐿️🐿️🐿️{블럭 처리 - 6/9}.이전 다음 처리🐿️🐿️🐿️ 
	//🐿️🐿️🐿️: 현재 블럭에서 이전/다음이 가능한지 계산하고 가능 여부를 저장해두기🐿️🐿️🐿️//
	boolean hasPrev = true;	//이전 블럭 가기 가능 여부 저장값 초기화.
	if(currentBlockNo == 1){	//현재 블럭이 1번 블럭이면
		hasPrev = false;		//이전 블럭 가기 불가능
	} else {					//현재 블럭이 1번 블럭이 아니면
		hasPrev = true;			//이전 블럭 가기 가능
		//🐿️🐿️🐿️: 이전 블럭 이동 시 몇 페이지로 이동할지 정하기🐿️🐿️🐿️//
		//이전 블럭의 마지막 페이지로 이동하게 하면 됨(보통 이렇게 처리하니까)
		//공식 : (현재 블럭 번호 - 1) * 블럭 당 페이지 수
		prevPage = (currentBlockNo - 1 ) * Board.PAGE_LINK_AMOUNT;
	}
	
	boolean hasNext = true;	//다음 블럭 가기 가능 여부 저장값 초기화.
	if(currentBlockNo < totalBlock ){	//현재 블럭이 마지막 블럭보다 작으면
		hasNext = true;					//다음 블럭 가기 가능
		//🐿️🐿️🐿️: 다음 블럭 이동 시 몇 페이지로 이동할지 정하기🐿️🐿️🐿️//
		//다음 블럭의 첫 페이지로 이동하게 하면 됨(보통 이렇게 처리하니까)
		//공식 : 현재 블럭 번호 * 블럭 당 페이지 수 + 1
		nextPage = currentBlockNo * Board.PAGE_LINK_AMOUNT + 1;		
	} else {							//현재 블럭이 마지막 블럭보다 같거나 크면(큰값이 오면 안되겠지만)
		hasNext = false;				//다음 블럭 가기 불가능
	}

	//🐿️🐿️🐿️{블럭 처리 - 7/9}.이전 다음 처리🐿️🐿️🐿️
	//🐿️🐿️🐿️: 이전 블럭 이동이 가능하면 미리 계산한 이전 블록 이동 시 이동 할 페이지번호를 랑크에 전달하기🐿️🐿️🐿️//
	if(hasPrev){
		if(searchWord==null){	// <1>일반 리스트
%>
			<a href="list.jsp?page=<%=prevPage%>">🐿️이전블럭가기🐿️</a>
<%				
		} else {				// <2>검색어로 검색한 리스트
%>				
			<a href="list.jsp?page=<%=prevPage%>&word=<%=searchWord%>">🐿️이전블럭가기🐿️</a>
<%				
		}		
	}
	
	//🐿️🐿️🐿️{블럭 처리 - 8/9}.기존의 제한 없던 페이지리스트 나열을 ex.[1][2][3].....[n] 블럭 적용하기🐿️🐿️🐿️
	//🐿️🐿️🐿️현재 블럭의 페이지 시작번호와 끝번호를 이용하여 반복문의 시작값 끝값으로 하고 이 값을 페이지 번호로 출력하기🐿️🐿️🐿️
	//for(int i=1;i<=pageMaxNumber;i++){  			<< 이전 반복문을
	for(int i=blockStartNo;i<=blockEndNo;i++){	// 	<< 이렇게 바꿈
		if(nPageNum == i){
%>
			🌰<%=i %>🌰
<%
		} else {
			//<검색처리 5/5>.하단 페이지 링크 리스트 출력 및 링크처리를 검색모드/일반모드 구분해서 처리			
			if(searchWord==null){	// <1>일반 리스트
%>				
			🌰<a href="list.jsp?page=<%=i %>"><%=i %></a>🌰
<%				
			} else {				// <2>검색어로 검색한 리스트
				//*중요* 한글 검색어를 전달할 때는 url인코딩을 해줘야함. 영어는 괜찮음. 그래도 다 해주고..
				String urlEncodedSearchWord = java.net.URLEncoder.encode(searchWord);				
%>				
				🌰<a href="list.jsp?page=<%=i %>&word=<%=urlEncodedSearchWord%>"><%=i %></a>🌰
<%				
			}			
		}
	}
	//🐿️🐿️🐿️{블럭 처리 - 9/9}.이전 다음 처리🐿️🐿️🐿️
	//🐿️🐿️🐿️: 다음 블럭 이동이 가능하면 미리 계산한 이전 블록 이동 시 이동 할 페이지번호를 랑크에 전달하기🐿️🐿️🐿️//
	if(hasNext){
			if(searchWord==null){	// <1>일반 리스트
%>
				<a href="list.jsp?page=<%=nextPage%>">🐿️다음블럭가기🐿️</a>
<%				
			} else {				// <2>검색어로 검색한 리스트
%>				
				<a href="list.jsp?page=<%=nextPage%>&word=<%=searchWord%>">🐿️다음블럭가기🐿️</a>
				
<%				
			}			
	}
%>

<form action="list.jsp">
	<input name="word">
	<input type="submit" value="검색">
</form>

<a href="list.jsp">list로</a>

</body>
</html>
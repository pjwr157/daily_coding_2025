package com.peisia.c.board.display;

import com.peisia.util.Cw;

public class Disp {
	static private String TITLE = "고양이 게시판";
	static private String VERSION = " v0.0.7";
	static private String FEAT = " sm.ahn";
	public static void title() {
		Cw.line();
		Cw.dot();
		Cw.space(20);
		Cw.w(TITLE);
		Cw.w(VERSION);
		Cw.w(FEAT);
		Cw.space(20);
		Cw.dot();
		Cw.wn();
		Cw.line();
	}
	public static void menuMain() {
		Cw.dot();
		Cw.w("[1]글리스트 [2]글읽기 [3]글쓰기 [4]글삭제 [5]글수정 [6]검색 [0]관리자 [e]프로그램종료");
		Cw.dot();
		Cw.wn();
	}
	static public void titleList() {
		Cw.wn("==========================================");
		Cw.wn("================= 글리스트 ==================");
		Cw.wn("==========================================");
		Cw.wn("글번호 글제목 작성자id 작성시간");
	}
	public static void replyBar() {
		Cw.wn("================= 댓글 리스트 ==================");
	}	
}

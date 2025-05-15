package com.peisia.db;
import java.sql.ResultSet;
import java.util.ArrayList;
public class Dao extends Da{
	/* (1/5)삭제 */
	public void del(String no) {
		super.connect();	//conect()라고 해도 됨.	//[고정1,2,3]
//		connect();
		String sql = String.format("delete from %s where b_no=%s"
				,Db.TABLE_PS_BOARD_FREE, no);
		super.update(sql);
		super.close();	//[고정4,5]
	}
	/* (2/5)쓰기 */
	public void write(Dto d) {
		super.connect();	//[고정1,2,3]
		String sql = String.format(
				"insert into %s (b_title,b_id,b_text) values ('%s','%s','%s')"
				,Db.TABLE_PS_BOARD_FREE, d.title,d.id,d.text);
		super.update(sql);
		super.close();	//[고정4,5]
	}
	/* (3/5)글 읽기 */
	public Dto read(String no) {
		super.connect();	//[고정1,2,3]
		Dto post = null;
		try {
			//여기에 코딩하시오:
			//sql 되는거 예문 아래에 복붙해두고 비교해서 작성하시고. (실무에선 혼남. 지울것)
//			select * from ps_board_free where b_no=4;
			String sql = String.format(
					"select * from %s where b_no=%s"
					,Db.TABLE_PS_BOARD_FREE, no);
			System.out.println("sql:"+sql);//todo
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			post = new Dto(
					rs.getString("B_NO"),
					rs.getString("B_TITLE"),
					rs.getString("B_ID"),
					rs.getString("B_DATETIME"),
					rs.getString("B_HIT"),
					rs.getString("B_TEXT"),
					rs.getString("B_REPLY_COUNT"),
					rs.getString("B_REPLY_ORI")
					);
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close();	//[고정4,5]
		return post;
	}	
	/* (4/5)글 리스트 */
	public ArrayList<Dto> list(String page) {
		super.connect();	//[고정1,2,3]
		ArrayList<Dto> posts = new ArrayList<>();
		try {

			int startIndex = ((Integer.parseInt(page))-1)*3;
			
			//여기에 코딩하시오:
			//sql 되는거 예문 아래에 복붙해두고 비교해서 작성하시고. (실무에선 혼남. 지울것)
//			select * from ps_board_free where b_no=4;
//			select * from board order by b_no desc limit 20,5;
			String sql = String.format(
					"select * from %s limit %s,3"
					,Db.TABLE_PS_BOARD_FREE,startIndex);
			System.out.println("sql:"+sql);
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {				
				posts.add(new Dto(
						rs.getString("B_NO"),
						rs.getString("B_TITLE"),
						rs.getString("B_ID"),
						rs.getString("B_DATETIME"),
						rs.getString("B_HIT"),
						rs.getString("B_TEXT"),
						rs.getString("B_REPLY_COUNT"),
						rs.getString("B_REPLY_ORI")
						));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close();	//[고정4,5]
		return posts;
	}
	/* (5/5)수정 */
	public void edit(Dto d,String no) {
		super.connect();	//[고정1,2,3]
		String sql = String.format(
				"update %s set b_title='%s',b_text='%s' where b_no=%s"
				,Db.TABLE_PS_BOARD_FREE, d.title,d.text,no);
		super.update(sql);
		super.close();	//[고정4,5]
	}
	/* 전체 글 수 구하기 */
	public int getPostCount() {
		int count = 0;
		super.connect();	//[고정1,2,3]
		try {
			//여기에 코딩하시오:
			//sql 되는거 예문 아래에 복붙해두고 비교해서 작성하시고. (실무에선 혼남. 지울것)
//			select * from ps_board_free where b_no=4;
			String sql = String.format(
					"select count(*) from %s"
					,Db.TABLE_PS_BOARD_FREE);
			System.out.println("sql:"+sql);//todo
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			count = rs.getInt("count(*)");
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.close();	//[고정4,5]
		return count;
	}	
}
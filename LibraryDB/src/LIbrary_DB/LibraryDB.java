package LIbrary_DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import Library_Function.LibraryBook;
import Library_UI.LibraryUI;

public class LibraryDB {

	ArrayList<LibraryBook> bookList = new ArrayList<LibraryBook>();
	LibraryUI UImanager = new LibraryUI();
	ResultSet rs = null;
	Statement st= null;
	Connection conn = null;             

	String DB_url ="jdbc:mysql://localhost:3306/librarybeom"; // /스키마;
	String DB_id=  "root";
	String DB_pw = "1234";

	final static int nameMember=0;
	final static int idMember=1;
	final static int pwMember=2;
	final static int pnMember=3;
	final static int emailMember=4;

	
	public void DB_DeleteMEMBER(String [] temp)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(DB_url,DB_id,DB_pw);
			st =conn.createStatement();

			String deleteSQL="delete from member where idMember ='"+temp[1]+"'";
			st.executeUpdate(deleteSQL);


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void DB_UpdateMEMBER(String [] temp)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(DB_url,DB_id,DB_pw);
			st =conn.createStatement();

			String updateSQL="update member set ";
			updateSQL+="nameMember='"+temp[0]+"', pwMember='"+temp[2]
					+"', pnMember='"+temp[3]+"',emailMember='"+temp[4]+"' where idMember='"
					+temp[1]+"'";
			System.out.println(updateSQL);
			st.executeUpdate(updateSQL);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean DB_CheckMEMBER(String id)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(DB_url,DB_id,DB_pw);
			st =conn.createStatement();

			String checkSQL="select * from member where idMember='"+id+"'";
			rs=st.executeQuery(checkSQL);

			if(rs.next()) return false;	//해당 id가 존재하면 false
			else return true;	//없다면 true

		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	//로그인 시 회원의 정보를 담아올 String 배열리턴
	public String[] memberInfo(String id)
	{
		String[] info = new String[5];

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(DB_url,DB_id,DB_pw);
			st =conn.createStatement();

			String checkSQL="select * from member where idMember='"+id+"'";
			rs=st.executeQuery(checkSQL);
			while(rs.next())
			{
				info[nameMember]=rs.getString("nameMember");
				info[idMember]=rs.getString("idMember");
				info[pwMember]=rs.getString("pwMember");
				info[pnMember]=rs.getString("pnMember");
				info[emailMember]=rs.getString("emailMember");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return info;

	}


	//**********************질문 ********************************
	//resultSET을 return type으로 해서 각 클래스에서 반환받아서 사용하고싶은데
	//마지막에 ResultSet rs 객체를 close()해주게 되면 사용하지 못해서 안 닫아주고 쓰면 잘되는데
	//그렇게 안닫고 써도 되는건지? 그러면 정말 편할거 같은데...
	ResultSet DB_CheckMEMBER2(String id)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(DB_url,DB_id,DB_pw);
			st =conn.createStatement();

			String checkSQL="select * from member where idMember='"+id+"'"; //로그인 아이디가 table에 있는지 검색
			rs=st.executeQuery(checkSQL); //rs에 담아줌
		}catch (Exception e){
			e.printStackTrace();
		}
		return rs; //rs가 비어있는 담겨있든 통째로 리턴.

	}
	//***************************************************

	public void DB_OutMEMBER(String name, String id, String pw, String pn,String email)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(DB_url,DB_id,DB_pw);
			st =conn.createStatement();

			String insertSQL="INSERT into member values(";
			insertSQL+="'"+name+"','"+id+"','"+pw+"','"+pn+"','"+email+"')";
			st.executeUpdate(insertSQL);

		} catch (Exception e) {

			e.printStackTrace();
		}finally
		{
			try {
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//book 데이터베이스 다 삭제하고 다시 새롭게 업데이트하는 방법.
	public void DB_OutBOOK(ArrayList<LibraryBook> tempList)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(DB_url,DB_id,DB_pw);
			st =conn.createStatement();

			String sql="DELETE FROM book";
			st.executeUpdate(sql);

			for(int index=0; index<tempList.size();index++)
			{
				String insertSQL=UImanager.returnToBookList(tempList, index);
				st.executeUpdate(insertSQL);
			}
		} catch (Exception e) {
			System.out.println("에러떴따.");
			e.printStackTrace();
		}finally
		{
			try {
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<LibraryBook> DB_inBOOK()	//데이터베이스로부터 책 정보를 읽어와서 bookList에 담아서 리턴
	{
		try {
			conn=DriverManager.getConnection(DB_url,DB_id,DB_pw);
			st =(Statement)conn.createStatement();
			String sql = "SELECT * FROM book";	

			rs = st.executeQuery(sql);

			while(rs.next())
			{                                                      
				String n = rs.getString("nameBook");
				String a = rs.getString("authorBook");
				String pr = rs.getString("priceBook");
				String pa= rs.getString("pageBook");
				String s= rs.getString("stateBook");
				String w= rs.getString("whereBook");
				String dd= rs.getString("duedateBook");

				bookList.add( new LibraryBook(n,a,pr,pa,s,w,dd) );
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return bookList;
	}







}

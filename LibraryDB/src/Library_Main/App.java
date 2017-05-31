package Library_Main;
import java.sql.ResultSet;
/*
 1.클래스를 패키지화
 2."대여가능" - > 스트링변수로 만들어서 저장하는식으로
 3.UI클래스 만들어서 기본 메서드 따로 정리
 4.어레이리스트 담지않고도 바로바로 데이터 베이스 접근
  방법으로 문제해결하는 코드 작성해보기
 5.회원가입시 3회이상 아이디 중복될때 종료.
 
 **질문**LibraryDB.DB_CheckMEMBER2(String id) 이 메서드부분.
 */
import java.util.Scanner;

import Library_UI.LibraryPrintMenu;


public class App {
	
	public static void main(String[] args) {
		
		new LibraryRunBeggining();
	}

}

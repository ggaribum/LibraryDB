package Library_UI;

import java.util.Scanner;

public class LibraryPrintMenu {
	public static void baseMenu()
	{
		System.out.println("			초기화면		");
		System.out.println("		 \"로그인\" 또는 \"계정만들기\" ");
		System.out.println("		1. Sign In	2. Sign Up	3. EXIT");
		System.out.print("		(숫자만 입력하시오) :");
	}
	public static void signIn()
	{
		System.out.println("		┏━━━━━━┓");
		System.out.println("		┃ 로  그  인 ┃");
		System.out.println("		┗━━━━━━┛");
		System.out.println("");
	}
	public static void signUp()
	{
		System.out.println("		┏━━━━━━┓");
		System.out.println("		┃회 원 가 입┃");
		System.out.println("		┗━━━━━━┛");
		System.out.println("");
	}
	public static void userMenu()
	{
		System.out.println("		┏━━━━━━┓");
		System.out.println("		┃ 사용자메뉴 ┃");
		System.out.println("		┗━━━━━━┛");
		System.out.println("");
		System.out.println("		1. 도서검색");
		System.out.println("		2. 전체도서출력");
		System.out.println("		3. 도서대여");
		System.out.println("		4. 도서반납");
		System.out.println("		5. 회원정보수정");
		System.out.println("		6. 로그아웃");
		System.out.println("		7. 회원탈퇴");
	}
	
	public static void withdraw()
	{
		System.out.println("		┏━━━━━━┓");
		System.out.println("		┃회 원 탈 퇴┃");
		System.out.println("		┗━━━━━━┛");
		System.out.println("");
	}
	public static void searchbook()
	{
		System.out.println("		┏━━━━━━┓");
		System.out.println("		┃도 서 검 색┃");
		System.out.println("		┗━━━━━━┛");
		System.out.println("");
		System.out.println("		1. 책 제목");
		System.out.println("		2. 책 저자");
		System.out.println("		3. 제목and저자");
		System.out.println("		4. 뒤로가기");
		System.out.print("		귀하의 선택은 ? :");
	}
	
	public static void rentbook()
	{
		System.out.println("		┏━━━━━━┓");
		System.out.println("		┃도 서 대 여┃");
		System.out.println("		┗━━━━━━┛");
		System.out.println("");
		System.out.println("		1. 책 제목");
		System.out.println("		2. 책 저자");
		System.out.println("		3. 제목and저자");
		System.out.println("		4. 뒤로가기");
		System.out.print("		귀하의 선택은 ? :");
	}
	public static void returnbook()
	{
		System.out.println("		┏━━━━━━┓");
		System.out.println("		┃도 서 반 납┃");
		System.out.println("		┗━━━━━━┛");
		System.out.println("");
	}
	public static void modifyinfo()
	{
		System.out.println("		┏━━━━━━━┓");
		System.out.println("		┃회원정보 수정┃");
		System.out.println("		┗━━━━━━━┛");
		System.out.println("");
		
	}
	
	public static void jump()
	{
		for(int i=0; i<30 ; i++)
		{
		System.out.println("");
		}
	}
	public static void pressanykey()
	{
		System.out.println("목록의 마지막입니다. <press [ENTER] key..>");
		new Scanner(System.in).nextLine();
	}
	
	public static void sleep()
	{
		System.out.println("		2초 후 이전 화면으로 돌아갑니다...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

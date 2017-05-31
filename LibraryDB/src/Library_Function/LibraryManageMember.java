package Library_Function;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import LIbrary_DB.LibraryDB;
import Library_UI.LibraryException;
import Library_UI.LibraryPrintMenu;



public class LibraryManageMember {

	private String Name="";
	private String Id="";
	private String Pw="";
	private String PhoneNum="";
	private String Email="";
	boolean flagSign = false;

	Scanner scan = new Scanner(System.in);
	LibraryDB dbManager = new LibraryDB();
	LibraryException exceptionManager = new LibraryException();
	ResultSet temp=null;

	public void signIn()
	{
		String signinID="";
		String signinPW="";
		LibraryPrintMenu.jump();
		LibraryPrintMenu.signIn();

		System.out.print("		아이디 입력: ");
		signinID=scan.nextLine();

		if(dbManager.DB_CheckMEMBER(signinID))
		{
			System.out.println("		존재하지 않는 ID입니다.");
			LibraryPrintMenu.sleep();
			return ;
		}
		
		String [] memberInfo=dbManager.memberInfo(signinID); //위에 if문을 통과해서 존재하는 아이디라면 info 담아옴

		System.out.print("		비밀번호입력 :");
		signinPW=scan.nextLine();
		if(signinPW.equals(memberInfo[2]))
		{
			System.out.println("		반갑습니다 "+memberInfo[0]+"씨♥");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
			LibraryUserMenu obj=new LibraryUserMenu(memberInfo);
			return ;
		}
		else
		{
			System.out.println("		비밀번호가 틀렸습니다.");
			LibraryPrintMenu.sleep();
			return ;
		}

	}
	public void signUp()
	{
		LibraryPrintMenu.jump();
		LibraryPrintMenu.signUp();

		setSignUp();
		if(exceptionManager.IDexception(Id)&&exceptionManager.PWexception(Pw)&&
				exceptionManager.PHONEexception(PhoneNum))
		{
			dbManager.DB_OutMEMBER(this.Name,this.Id,this.Pw,this.PhoneNum,this.Email);
			System.out.println("		회원가입해 주셔서 감사합니다 "+Name+"씨.");
			LibraryPrintMenu.sleep();
		}
		else{
			System.out.println("		형식에맞게 입력하셔야 합니다");
			LibraryPrintMenu.sleep();
		}
	}

	//private 변수들 setter getter Part.
	
	public void setSignUp()
	{
		System.out.print("		Name :");
		setName(scan.nextLine());
		System.out.print("		ID :");
		setId();
		System.out.print("		PW :");
		setPw(scan.nextLine());
		System.out.print("		PhoneNumber :");
		setPhoneNum(scan.nextLine());
		System.out.print("		Email :");
		setEmail(scan.nextLine());
	}
	
	public void setName(String name)
	{
		this.Name=name;
	}

	public void setId() {
		int count=0;
		this.flagSign=false;

		while((!flagSign))
		{
			String id =scan.nextLine();
			if(dbManager.DB_CheckMEMBER(id) )
			{
				this.Id = id;
				this.flagSign=true;			//while문 빠져나옴.	
			}
			else{
				System.out.println("		아이디가 중복됩니다.");
				System.out.print("		ID 재입력:");
				count++; //3회이상 반복시 종료되게 생각해보기.
			}
		}
	}

	public void setPw(String pw) {
		this.Pw = pw;
	}

	public void setPhoneNum(String phoneNum) {
		this.PhoneNum = phoneNum;
	}

	public void setEmail(String email) {
		this.Email = email;
	}
}

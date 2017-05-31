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

		System.out.print("		���̵� �Է�: ");
		signinID=scan.nextLine();

		if(dbManager.DB_CheckMEMBER(signinID))
		{
			System.out.println("		�������� �ʴ� ID�Դϴ�.");
			LibraryPrintMenu.sleep();
			return ;
		}
		
		String [] memberInfo=dbManager.memberInfo(signinID); //���� if���� ����ؼ� �����ϴ� ���̵��� info ��ƿ�

		System.out.print("		��й�ȣ�Է� :");
		signinPW=scan.nextLine();
		if(signinPW.equals(memberInfo[2]))
		{
			System.out.println("		�ݰ����ϴ� "+memberInfo[0]+"����");
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
			System.out.println("		��й�ȣ�� Ʋ�Ƚ��ϴ�.");
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
			System.out.println("		ȸ�������� �ּż� �����մϴ� "+Name+"��.");
			LibraryPrintMenu.sleep();
		}
		else{
			System.out.println("		���Ŀ��°� �Է��ϼž� �մϴ�");
			LibraryPrintMenu.sleep();
		}
	}

	//private ������ setter getter Part.
	
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
				this.flagSign=true;			//while�� ��������.	
			}
			else{
				System.out.println("		���̵� �ߺ��˴ϴ�.");
				System.out.print("		ID ���Է�:");
				count++; //3ȸ�̻� �ݺ��� ����ǰ� �����غ���.
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

package Library_UI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryException {

	public void isEmptyList(int i)
	{
		if(i!=0)
		{
			LibraryPrintMenu.pressanykey();
		}
		else
		{
			System.out.println("�˻������ �����ϴ�.");
			LibraryPrintMenu.pressanykey();
		}
	}
	public int inputNumber(int boundaryNum)
	{
		try{
			int i=new Scanner(System.in).nextInt();
			if(!(0<i && i<boundaryNum+1))

			{
				System.out.println("		�Է� ������ ������ϴ�. �ٽ� �Է��ϼ���");
				LibraryPrintMenu.sleep();
				return 0;

			}
			else return i;
		}catch (InputMismatchException e) {
			System.out.println("		������ �Է��ϼ���.");
			LibraryPrintMenu.sleep();
			return 0;
		}
	}

	public String yesORno()
	{	
		String s=new Scanner(System.in).nextLine();
		s=s.toUpperCase();//.charAt(0);
		if(!(s.equals("Y") || s.equals("N")))
		{
			System.out.println("Y / N ���θ� �Է��� �ּ���.");
			return s=null;
		}

		else return s;
	}
	public boolean numberBoundary(int num)
	{	
		Integer a=num;
		if(a instanceof Integer){return true;}
		return false;
	}

	public boolean PHONEexception(String phoneNum)
	{
		if( (phoneNum.charAt(3)!='-') || (phoneNum.charAt(8)!='-') || (phoneNum.length()!=13) )
		{
			System.out.println("		[�� ȭ �� ȣ]");
			return false;
		}
		return true;
	}
	
	public boolean IDexception(String id)
	{
		if(id.length()<4 || 12<id.length())
		{
			System.out.println("		[�� �� ��]");
			return false;
		}
		return true;
	}
	
	public boolean PWexception(String pw)
	{	
		if(pw.length()<4 || 12<pw.length() )
		{
			System.out.println("		[�� �� �� ȣ]");
			return false ;
		}
		return true;
	}

}

package Library_Main;

import java.util.Scanner;

import Library_Function.LibraryManageMember;
import Library_UI.LibraryException;
import Library_UI.LibraryPrintMenu;

public class LibraryRunBeggining {
	
	final static int SIGNIN =1;
	final static int SIGNUP =2;
	final static int EXIT =3;

	public LibraryRunBeggining() 
	{
		LibraryException exceptionManager= new LibraryException();
		LibraryManageMember obj = new LibraryManageMember();
		Scanner sc= new Scanner(System.in);
		int selectNum=0;
		
		while(true)
		{
			LibraryPrintMenu.jump();
			LibraryPrintMenu.baseMenu();
			
			selectNum=exceptionManager.inputNumber(3);
			
			switch(selectNum)
			{
			case 0 : continue;
			case SIGNIN: obj.signIn();break;
			case SIGNUP: obj.signUp();break;
			case EXIT:return;
			}
			
		}
		
	}




}

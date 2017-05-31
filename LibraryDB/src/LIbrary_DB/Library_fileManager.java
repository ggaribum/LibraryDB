package LIbrary_DB;
/*package library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Library_fileManager {

	ArrayList<Library_book>bookList=new ArrayList<Library_book>();
	BufferedReader br= null;
	BufferedWriter bw= null;
	FileInputStream fin = null;
	FileInputStream fin2 = null;
	FileWriter fout = null;
	File memberDIR =new File("src/MemberDirectory"); //여기가 질문인데 이미 디렉토리가 있으면 생성안함
	File del=null;
	//처리가 자동으로 되는지 아니면 해야하는지..
	File temp =null;

	String memberFileName = "Info_";
	String tempString="";
	String memberInfo="";
	String bookInfo="";

	void makeDIR()
	{
		memberDIR.mkdir();//멤버정보를 저장할 디렉토리 생성
	}

	void fileDelete(String id)
	{
		id="Info_"+id.toUpperCase()+".txt";
		String path="src/MemberDirectory/"+id;
		del=new File(path);
		System.out.println("삭제완료");
		Library_printMenu.sleep();
		del.delete(); //왜 삭제가 안될까..실행중인 파일이라 접근이 안되는건가..?

	}
	String fileInInfo(String id)
	{
		id="Info_"+id+".txt";

		temp= new File(memberDIR,""); //temp의 경로를 memberDIR로
		File read_dir[]=temp.listFiles();// read_dir[]배열에 디렉토리 안의 파일을 담는다.

		for(int i=0; i< read_dir.length;i++)
		{
			if(id.equals(read_dir[i].getName() ) ) //아이디와 같은 정보가 디렉토리에 있다면
			{
				try {
					//이 방법 기억해 두기 ********************
					br= new BufferedReader(new FileReader(read_dir[i]));
					while( ( tempString=br.readLine() ) != null )
					{
						memberInfo=tempString;
					}

				} catch (IOException e) {
					e.printStackTrace();
				}
				//*********************************
				return memberInfo;
			}
		}
		return "NOTFOUND";
	}

	void memberUpdate(String []s)
	{
		String fileNameTemp;
		fileNameTemp="Info_"+s[1].toUpperCase()+".txt";
		String path="src/MemberDirectory/"+fileNameTemp;

		try (BufferedWriter bfw= new BufferedWriter(new FileWriter(path));)
		{
			for(int i=0;i<s.length;i++)
			{
				bfw.write(s[i]);
				bfw.write(",");
			}
		}catch (IOException e) 
		{
			e.printStackTrace();
		}

	}
	void bookUpdate(ArrayList<Library_book> tempList)
	{
		String path="src/LibBook.txt";
		try {
			bw=new BufferedWriter(new FileWriter(path));
			for(int i=0; i<tempList.size();i++)
			{
				bw.write(tempList.get(i).name);
				bw.write(",");
				bw.write(tempList.get(i).author);
				bw.write(",");
				bw.write(tempList.get(i).price);
				bw.write(",");
				bw.write(tempList.get(i).page);
				bw.write(",");
				bw.write(tempList.get(i).state);
				bw.write(",");
				bw.write(tempList.get(i).host);
				bw.write(",");
				bw.write(tempList.get(i).due_date);
				bw.newLine();
			}
			bw.flush();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	ArrayList<Library_book> fileInBook()
	{
		int i=0;
		String path="src/LibBook.txt";
		//temp=new File(path);
		try {
			br= new BufferedReader(new FileReader(path));
			while( ( tempString=br.readLine() ) != null )
			{
				bookInfo=tempString;
				String bookInfo2[]=bookInfo.split(",");
				bookList.add(new Library_book( bookInfo2[0], 
						bookInfo2[1], bookInfo2[2], bookInfo2[3], 
						bookInfo2[4],bookInfo2[5],bookInfo2[6])
						);
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bookList;
	}


	boolean fileInCheck(String id)
	{
		id="Info_"+id+".txt";	//id중복 검사위해 파일명과 비교할려고.

		temp=new File(memberDIR,"");
		File read_dir[]=temp.listFiles();

		for(int i=0; i<read_dir.length;i++)
		{
			if(id.equals(read_dir[i].getName())) //만약 MemberDirectory에 아이디가 중복되면
			{return false;}
		}
		return true;
	}

	void fileOut(String msg,String memberFileName)
	{

		try {
			temp=new File(memberDIR,this.memberFileName+memberFileName+".txt");
			temp.createNewFile();
			fout= new FileWriter(temp);

			fout.write(msg);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fout.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
*/
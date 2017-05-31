package Library_Function;

public class LibraryBook {

	LibraryBook BOOK[];
	
	public String name="";
	public String author="";
	public String price="";
	public String page="";
	public String state="";
	public String host="";
	public String due_date="";
	public LibraryBook() {
	
	}
	public LibraryBook(String n,String a,String pr,String pa,String s,String h, String d) 
	{
		this.name=n;
		this.author=a;
		this.price=pr;
		this.page=pa;
		this.state=s;
		this.host=h;
		this.due_date=d;
	}
}

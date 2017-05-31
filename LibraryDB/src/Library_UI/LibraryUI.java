package Library_UI;

import java.util.ArrayList;
import Library_Function.LibraryBook;

public class LibraryUI {

	public String returnToBookList(ArrayList<LibraryBook> tempList, int index)
	{
		String sql="insert into book values(";
		sql+="'"+tempList.get(index).name+"','"+tempList.get(index).author
				+"','"+tempList.get(index).price+"','"
				+tempList.get(index).page+"','"+tempList.get(index).state+"','"
				+tempList.get(index).host+"','"+tempList.get(index).due_date+"')";
		return sql;
	}
}

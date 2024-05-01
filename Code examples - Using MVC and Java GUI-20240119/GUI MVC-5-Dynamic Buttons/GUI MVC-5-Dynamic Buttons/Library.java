
import java.util.ArrayList;

public class Library {
	private ArrayList<Book> bookList = new ArrayList<Book>();
	
	public Library() {
		Book book1 = new Book("B001", "book1.jpg");
		Book book2 = new Book("B002", "book2.jpg");
		Book book3 = new Book("B003", "book3.jpg");
		Book book4 = new Book("B004", "book4.jpg");
		Book book5 = new Book("B005", "book3.jpg");
		
		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
		bookList.add(book4);
		bookList.add(book5);
	}
	
	public ArrayList<Book> getAllBook() {
		return bookList;
	}
}

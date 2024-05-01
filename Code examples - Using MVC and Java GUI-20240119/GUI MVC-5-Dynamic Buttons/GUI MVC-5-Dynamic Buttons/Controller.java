
import java.util.*;

public class Controller {
	private MainPage mainPage;
	private BookListPage bookListPage;
	private BookPage bookPage;
	
	private Library library;
	private ArrayList<Book> bookList;
	private ArrayList<String> idList;
	
	public Controller() {
		mainPage = new MainPage(this);
		bookPage = new BookPage(this);
		
		library = new Library();
		bookList = library.getAllBook();
		idList = new ArrayList<String>();
		
		for (int i=0; i<bookList.size(); i++) {
			Book book = bookList.get(i);			
			idList.add(book.getBookId());
		}
		
		bookListPage = new BookListPage(this, idList);
	}
	
	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.displayMainPage();
	}
	
	public void displayMainPage() {
		mainPage.display();
	}
	
	public void displayBookListPage() {
		bookListPage.display();
	}
	
	public void displayBookPage(int index) {
		Book book = bookList.get(index);
		String fileName = "img/"+book.getImgName();
		
		bookPage.display(fileName);
	}
}

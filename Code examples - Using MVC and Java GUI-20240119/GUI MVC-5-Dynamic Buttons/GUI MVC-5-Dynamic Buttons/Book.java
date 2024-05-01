
public class Book {
	private String bookId;
	private String imgName;
	
	public Book(String id, String img) {
		bookId = id;
		imgName = img;
	}
	
	public String getBookId() {
		return bookId;
	}
	
	public String getImgName() {
		return imgName;
	}
}

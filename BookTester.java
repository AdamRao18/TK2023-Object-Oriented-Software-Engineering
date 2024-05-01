import static org.junit.Assert.*;
import org.junit.Test;

public class BookTester {
	private Book book = new Book("The Hobbit", "J.R.R. Tolkien");

	@Test
	public void testGetTitle() {
		assertEquals("The Hobbit", book.getTitle());
	}

	@Test
	public void testGetAuthor() {
		// Method will pass if the author is as expected
	}
}

import static org.junit.Assert.*;
import org.junit.Test;

public class Tester3 {
	
	private Course course = new Course("TK2023", "OOSE");
	private Lecturer lect = new Lecturer("Adam");
	
	@Test
	public void testRightCourseCode() {
		// Method will pass if the code is as expected
		assertEquals("TK2023", course.getCode());
	}
	
	@Test
	public void testRightCourseName() {
		// Method will pass if the name is as expected
		assertEquals("OOSE", course.getName());
	}
	
	@Test
	public void testHasLecturer() {
		// Method will pass if the lecturer is not null
		course.setLecturer(lect);
		assertNotNull(course.getLecturer());
	}
	
	@Test
	public void testRightLecturer() {
		// Method will pass if the lecturer is as expected
		course.setLecturer(lect);
		assertEquals(lect, course.getLecturer());
		
	}
}

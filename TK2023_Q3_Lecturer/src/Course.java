public class Course {
	private String code;
	private String name;
	private Lecturer lecturer;
	
	public Course(String code, String name) {
		this.code = code;
		this.name = name;
	} 
	
	public String getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}
	
	public Lecturer getLecturer() {
		return lecturer;
	}
} 
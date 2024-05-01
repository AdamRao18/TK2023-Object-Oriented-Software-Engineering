
public class Controller {
	
	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.displayScreen(1);
	}
	
	public void displayScreen(int num) {
		if (num == 1) {
			new Screen1(this);
		}
		
		else if (num == 2) {
			new Screen2();
		}
		
		else if (num == 3) {
			new Screen3();
		}
	}
}

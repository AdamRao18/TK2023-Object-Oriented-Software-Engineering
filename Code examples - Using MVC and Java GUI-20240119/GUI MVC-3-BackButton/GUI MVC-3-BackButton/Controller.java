
public class Controller {
	private Screen1 screen1;
	private Screen2 screen2;
	private Screen3 screen3;
	
	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.displayScreen(1);
	}
	
	public void displayScreen(int num) {
		if (num == 1) {
			if (screen1 == null)
				screen1 = new Screen1(this);
			else
				screen1.setVisible(true);
		}
		
		else if (num == 2) {
			if (screen2 == null)
				screen2 = new Screen2(this);
			else
				screen2.setVisible(true);
		}
		
		else if (num == 3) {
			if (screen3 == null)
				screen3 = new Screen3(this);
			else
				screen3.setVisible(true);
		}
	}
}

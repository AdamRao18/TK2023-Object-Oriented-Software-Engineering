
public class Controller {
	private LoginPage loginPage;
	private WelcomePage welcomePage;
	private ErrorPage errorPage;
	
	private Library library;
	private Member member;
	
	public Controller() {
		library = new Library();
		
		loginPage = new LoginPage(this);
		welcomePage = new WelcomePage(this);
		errorPage = new ErrorPage(this);
	}

	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.displayLoginPage();
	}
	
	public void displayLoginPage() {
		loginPage.display();
	}
	
	public void login(String name, String password) {
		member = library.getMember(name, password);
		
		if (member != null)
			welcomePage.display(member.getName());
		
		else
			errorPage.display();
	}
	
	public void logout() {
		member = null;
		loginPage.display();
	}
}

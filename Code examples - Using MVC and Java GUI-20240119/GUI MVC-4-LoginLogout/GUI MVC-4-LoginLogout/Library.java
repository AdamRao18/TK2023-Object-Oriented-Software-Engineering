
import java.util.ArrayList;

public class Library {
	private ArrayList<Member> memberList = new ArrayList<Member>();
	
	public Library() {
		Member member1 = new Member("Josh", "pwd1");
		Member member2 = new Member("Jim", "pwd2");
		
		memberList.add(member1);
		memberList.add(member2);
	}
	
	public Member getMember(String name, String password) {
		for (Member member : memberList) {
			if (member.getName().equals(name) &&
				member.getPassword().equals(password))
				return member;
		}
		
		return null;
	}
}

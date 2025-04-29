package index;
import java.util.*;
public class Main {
	Scanner scan = new Scanner(System.in);
	ArrayList<Visitor> visitorVec = new ArrayList<>();
	public static void main(String[] args) {
		new Main();
	}
	
	
	public Main() {
		int input;
		fillVisitor();
		do {
			
			System.out.println("Visiting");
			System.out.println("====================");
			System.out.println("1. New Visit");
			System.out.println("2. Display All");
			System.out.println("3. Exit");
			System.out.print("Choose: ");
			input = scan.nextInt();
			scan.nextLine();
			
			switch(input) {
				case 1:{
					newVisit();
					break;
				}
				case 2:{
					displayAll();
					break;
				}
			}
		}while(input != 3);
	}
	
	void fillVisitor() {
		visitorVec.add(new Visitor("Ali", "c1", 30.0, null));
		visitorVec.add(new Member("Budi", "c2", 20.0, null, 0));
		visitorVec.add(new Member("Cici", "c3", 30.0, null, 0));
		visitorVec.add(new Member("Dona", "c4", 40.0, null, 0));
		visitorVec.add(new Member("Edan", "c5", 30.0, null, 9));
	}
	
	void displayAll() {
		for (Visitor visitor : visitorVec) {
			if(visitor instanceof Member) {
				System.out.printf("Member name: %s/%s\n", visitor.getName(), visitor.getCode());
				System.out.printf("Point amount: %d\n", ((Member) visitor).getPoint());
				
			}
			else System.out.printf("Visitor name: %s/%s\n", visitor.getName(), visitor.getCode());
			
			System.out.printf("Balance: %.1f\n", visitor.getBalance());
			if(visitor.getVisit().size() == 0) System.out.println("-No visit yet-");
			else {
				for (int i = visitor.getVisit().size()-1; i >= 0; i--) {
					System.out.printf("V%d. %s\n", i+1, visitor.getVisit().get(i));
				}
			} 
			System.out.println();
		}
		for(int i = 0; i < 6; i++) System.out.println("");
	}
	
	void newVisit() {
//		Visitor visitor = null;
		String id;
		Integer day, cost = 0;
		System.out.print("Enter your member ID: ");
		id = scan.nextLine();
		do {
			System.out.print("Enter your day [1-7]: ");
			day = scan.nextInt();
			scan.nextLine();
		}while(day < 1 || day > 7);
	
		if(day >= 1 && day <= 4) cost = 10;
		else if(day >= 5 && day <= 7) cost = 20;
		for (Visitor visitor : visitorVec) {
			if(id.equals(visitor.getCode())) {
				if((visitor.getBalance() - cost) >= 0) visitor.setBalance(visitor.getBalance()-cost);
				else {
					System.out.printf("Insufficent fund for %s\n", visitor.getName());
					for(int i = 0; i < 6; i++) System.out.println("");
					return;
				}
				System.out.printf("Welcome %s!\n", visitor.getName());
				if(visitor instanceof Member) {
					((Member) visitor).setPoint(((Member) visitor).getPoint()+1);
					if(((Member) visitor).getPoint() == 10) {
						((Member) visitor).setPoint(0);
						visitor.setBalance(visitor.getBalance() + 10.0);
					}
				}
				String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
				visitor.getVisit().add(days[day-1]);
				for(int i = 0; i < 6; i++) System.out.println("");
				return;
			}
			
		}
		System.out.println("Your ID is not found!");
		for(int i = 0; i < 6; i++) System.out.println("");
		return; 
		
	}

}

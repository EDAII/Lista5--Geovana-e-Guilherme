import java.util.ArrayList;

public class Class {
	String name;
	int dayOfTheWeek;
	int startTime;
	int duration;
	
	public Class(String name, int dayOfTheWeek, int startTime, int duration) {
		this.name = name;
		this.dayOfTheWeek = dayOfTheWeek;
		this.startTime = startTime;
		this.duration = duration;
	}
	
	public static ArrayList<Class> getRandomClasses(){
		//arrays to choose from, when selecting randomly
		
		//pick class name in order
		String[] className = {
				"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q"
		};
		
		int[] dayOfTheWeek = {
				1, 2, 3, 4, 5, 6
		};
		
		int[] startTime = {
				8, 9, 10, 11, 12, 13, 14, 15, 16, 17
		};
		
		int[] duration = {
				1, 2, 3
		}; // TODO need to check if duration exceeds schedule max time
		
		ArrayList<Class> classes = new ArrayList<>();
		
		//TODO generate random classes to add to table
		
		
		// this part is just for tests
		// remove later
		for (int i=8; i <= 17; i++) {
			classes.add(new Class(className[i-8], 1, i, 2));
			System.out.println(className[i-8] + 1 + i + 2);
		}
		
		return classes;
	}
	
	public static ArrayList<Class> getSortedClasses(ArrayList<Class> classes){
		
		//TODO run interval scheduling algorithm to sort classes

		return classes;
	}

}

import java.util.ArrayList;
import java.util.Random;

import javax.management.InvalidAttributeValueException;

public class Class {
	String name;
	int dayOfTheWeek;
	int startTime;
	int duration;
	
	static final int[] validDays = {
			1, 2, 3, 4, 5, 6
	};
	
	static final int[] validStart = {
			8, 9, 10, 11, 12, 13, 14, 15, 16, 17
	};
	
	static final int[] validDuration = {
			1, 2, 3
	}; 
	
	
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
				"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "Y", "Z"
		};
		
	
		ArrayList<Class> classes = new ArrayList<>();
		
		for (int i = 0; i < className.length; i++) {
			
			Class c = getRandomClass(className[i]);
			
			classes.add(c);
		}
		

		return classes;
	}
	
	private static Class getRandomClass(String className) {
	
		Random r = new Random();
		
		int day = Class.validDays[r.nextInt(Class.validDays.length)];
		int duration, startTime; 
		
		do {
			// don't generate something outside of 'school day'
		
			duration = Class.validDuration[r.nextInt(Class.validDuration.length)];
			startTime = Class.validStart[r.nextInt(Class.validStart.length)];
			
		} while(startTime + duration >= 18);
				
		return new Class(className, day, startTime, duration);
	};
	
	public static ArrayList<Class> getSortedClasses(ArrayList<Class> classes){
		
		//TODO run interval scheduling algorithm to sort classes

		return classes;
	}

}

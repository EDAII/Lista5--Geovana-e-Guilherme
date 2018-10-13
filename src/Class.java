import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Class {
	String name;
	int dayOfTheWeek;
	int startTime;
	int duration;
	int endTime;
	
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
		this.endTime = startTime + duration;
		
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
		
		ArrayList<Class> mon = new ArrayList<>();
		ArrayList<Class> tu = new ArrayList<>();
		ArrayList<Class> wed = new ArrayList<>();
		ArrayList<Class> thu = new ArrayList<>();
		ArrayList<Class> fri = new ArrayList<>();
		ArrayList<Class> sat = new ArrayList<>();
		
		ArrayList<Class> sorted = new ArrayList<>();
		
		for(Class c : classes) {
			if(c.dayOfTheWeek == 1) {
				mon.add(c);
			} else if(c.dayOfTheWeek == 2) {
				tu.add(c);
			} else if(c.dayOfTheWeek == 3) {
				wed.add(c);
			} else if(c.dayOfTheWeek == 4) {
				thu.add(c);
			} else if(c.dayOfTheWeek == 5) {
				fri.add(c);
			} else if(c.dayOfTheWeek == 6) {
				sat.add(c);
			}
		}
		
		Collections.sort(mon, classEndTime);
		Collections.sort(tu, classEndTime);
		Collections.sort(wed, classEndTime);
		Collections.sort(thu, classEndTime);
		Collections.sort(fri, classEndTime);
		Collections.sort(sat, classEndTime);
		
		sorted = intervalScheduling(mon, sorted);
		sorted = intervalScheduling(tu, sorted);
		sorted = intervalScheduling(wed, sorted);
		sorted = intervalScheduling(thu, sorted);
		sorted = intervalScheduling(fri, sorted);
		sorted = intervalScheduling(sat, sorted);


		return sorted;
	}
	
	private static ArrayList<Class> intervalScheduling(ArrayList<Class> classes, ArrayList<Class> sorted) {
	
		sorted.add(classes.get(0));
		
		for(int i = 1; i < classes.size(); i++) {
			if(classes.get(i).startTime >= sorted.get(sorted.size()-1).endTime ) {
				sorted.add(classes.get(i));
			}
		}
		
		return sorted;
		
	}
	

    private static Comparator<Class> classEndTime = new Comparator<Class>() {

		public int compare(Class a, Class b) {
	
		   int endTime1 = a.endTime;
		   int endTime2 = b.endTime;
	
	
		   return endTime1-endTime2;
	

	    }
	};

}

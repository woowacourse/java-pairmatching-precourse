package pairmatching;

public class Pair {
	static Course course;
	static Level level;
	static String mission;
	Pair(Course course,Level level,String mission){
		this.course =course;
		this.level = level;
		this.mission = mission;
	}
	Course getCourse(){
		return course;
	}
	Level getLevel(){
		return level;
		
	}
	String getMission(){
		return mission;
		
	}
	
}

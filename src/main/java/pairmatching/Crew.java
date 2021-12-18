package pairmatching;

public class Crew {
    private Course course;
    private String name;
    private String matchCrewName;
    private String finalCrewName;
    
    Crew(String name, String matchCrewName){
    	this.name =name;
    	this.matchCrewName= matchCrewName;
    }
    Crew(String name, String matchCrewName, String finalCString){
    	this.name =name;
    	this.matchCrewName= matchCrewName;
    	this.finalCrewName = finalCString;
    }
}

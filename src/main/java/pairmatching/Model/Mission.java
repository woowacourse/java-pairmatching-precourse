package pairmatching.Model;

public class Mission {
    private Course course;
    private Level level;
    private String name;

    public Mission(Course course, Level level, String name) {
        this.course = course;
        this.level = level;
        this.name = name;
    }

    public boolean isSameMission(Course targetcourse, Level targetlevel, String missionName){
        if(course.equals(targetcourse) && level.equals(targetlevel) && name.equals(missionName)){
            return true;
        }
        return false;
    }
}

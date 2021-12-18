package pairmatching.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CourseLevelInfo {
    private static List<Course> courseList;
    private static Map<Level, List<Game>> levelMission;

    public static List<Course> getCourseList(){
        return courseList;
    }

    public static Map<Level, List<Game>> getLevelMission(){
        return levelMission;
    }

    public static void init() {
        createCourseList();
        createLevelMissionList();
    }

    private static void createCourseList() {
        courseList = new ArrayList<>();
        for(Course course : Course.values()){
            courseList.add(course);
        }
    }

    private static void createLevelMissionList() {
        levelMission = new LinkedHashMap<>();
        for(Level level : Level.values()){
            levelMission.put(level, new ArrayList<>());
        }
        for(Game game : Game.values()){
            levelMission.get(game.getLevel()).add(game);
        }
    }

    public static boolean existCourse(String inputCourse){
        for(Course course: courseList){
            if(course.getName().equals(inputCourse)){
                return true;
            }
        }
        return false;
    }

    public static boolean existLevel(String inputLevel){
        for(Map.Entry<Level, List<Game>> m: levelMission.entrySet()){
            if(m.getKey().getName().equals(inputLevel)){
                return true;
            }
        }
        return false;
    }
    public static boolean existMission(String inputMission){
        for(Map.Entry<Level, List<Game>> m: levelMission.entrySet()){
            if(existMissionGame(inputMission, m.getValue())){
                return true;
            }
        }
        return false;
    }

    private static boolean existMissionGame(String inputMission, List<Game> G){
        for(Game game : G){
            if(game.getName().equals(inputMission)){
                return true;
            }
        }
        return false;
    }

}

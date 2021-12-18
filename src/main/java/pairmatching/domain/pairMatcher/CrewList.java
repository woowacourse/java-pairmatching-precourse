package pairmatching.domain.pairMatcher;

import pairmatching.constant.ErrorMessage;
import pairmatching.domain.pairMatcher.enums.Course;
import pairmatching.domain.pairMatcher.enums.Level;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CrewList {
    final static int COURSE_INDEX = 0;
    final static int LEVEL_INDEX = 1;
    final static int MISSION_INDEX = 2;

    private List<String> crewList;
    private String course;
    private String level;
    private String mission;

    CrewList(String info) throws IllegalArgumentException {
        ArrayList<String> infoList = new ArrayList<>(Arrays.asList(info.split(", ")));
        isContainsAllInfo(infoList);

        String courseName = infoList.get(COURSE_INDEX);
        String levelName = infoList.get(LEVEL_INDEX);
        String missionName = infoList.get(MISSION_INDEX);

        infoValidator(courseName, levelName, missionName);
        this.course = courseName;
        this.level = levelName;
        this.mission = missionName;

        crewList = new ArrayList<String>();
        makeCrewList();
    }

    private void infoValidator(String courseName, String levelName, String missionName) throws IllegalArgumentException {
        isExistCourse(courseName);
        isExistLevel(levelName);
        isExistMission(missionName);
    }

    private void isExistCourse(String courseName) throws IllegalArgumentException {
        for (Course course : Course.values()) {
            if (course.getName().equals(courseName)) {
                return;
            }
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_COURSE.print());
        }
    }

    private void isExistLevel(String levelName) throws IllegalArgumentException {
        for (Level level : Level.values()) {
            if (level.getName().equals(levelName)) {
                return;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_LEVEL.print());
    }

    private void isExistMission(String missionName) throws IllegalArgumentException {
        for (Level level : Level.values()) {
            if (level.isExistMission(missionName)) {
                return;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_MISSION.print());
    }

    private void isContainsAllInfo(ArrayList<String> infoList) throws IllegalArgumentException{
        if (infoList.size() != 3) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_COURSE.print());
        }
    }

    private void makeCrewList() {
        try {
            File file = new File("src/main/resources/" + this.course + "-crew.md");
            FileReader filereader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(filereader);
            String crewName = "";
            while ((crewName = bufReader.readLine()) != null) {
                crewList.add(crewName);
            }
            bufReader.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public ArrayList<String> getCrewList() {
        return (ArrayList<String>) crewList;
    }
}

package pairmatching;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Controller {
    private View view;
    private static List<Crew> crewList= new ArrayList<Crew>();

    public Controller(View view){
        this.view = view;
    }

    public static boolean checkCorrectInput(String str) {
        if (str.equals("1")) {
            return true;
        }
        if (str.equals("Q")) {
            return true;
        }
        return false;

    }

    public static String inputMenu() {
        String result = View.inputMenu();
        if (checkCorrectInput(result)) {
            return result;
        }
        while (true) {
            System.out.println("매칭, 종료만 가능합니다.\n");
            result = View.inputMenu();
            if (checkCorrectInput(result)) {
                return result;
            }
        }
    }

    public static boolean isSameCourse(String[] course) {
        for (int i=0; i<crewList.size(); i++) {
            if (crewList.get(i).getName().equals(course[2])) {
                return true;
            }
        }
        return false;
    }

    public static void fairMatching() throws IOException {
        while (true) {
            String[] course = View.selectCourse().split(", ");
            if (isSameCourse(course)) {
                View.rematch();
                continue;
            }
            makeCrew(course);
            shuffle();
            break;
        }
    }

    public static Course findCourse(String course) {
        Course[] values = Course.values();
        for (int i=0; i<values.length; i++) {
            if (values[i].getName().equals(course)) {
                return values[i];
            }
        }
        return null;
    }

    public static Level findLevel(String level) {
        Level[] values = Level.values();
        for (int i=0; i<values.length; i++) {
            if (values[i].getName().equals(level)) {
                return values[i];
            }
        }
        return null;
    }

    public static void makeCrew(String[] course) throws IOException {
        Course correctCourse = findCourse(course[0]);
        Level level = findLevel(course[1]);
        Crew crew = new Crew(correctCourse, course[2], correctCourse.getStudentList(), level);
        crewList.add(crew);
    }
/*
    public static boolean checkListSame(List<String> fistList, List<String> secondList) {
        for (int i=0; i<fistList.size(); i++) {

        }
    }
*/

    public static List<Crew> findSameLevel (Level level) {
        List<Crew> sameLevelCrewList= new ArrayList<Crew>();
        for (int i=0; i<crewList.size(); i++) {
            if (crewList.get(i).getLevel()==level) {
                sameLevelCrewList.add(crewList.get(i));
            }
        }
        return sameLevelCrewList;
    }

    public static boolean checkSame(Level level, List<String> shuffled) {
        List<Crew> sameLevelCrewList = findSameLevel(level);
        for (int i=0; i<sameLevelCrewList.size(); i++) {
            //checkListSame(sameLevelCrewList.get(i).getStudentList(),shuffled);
        }
        return true;
    }

    public static void shuffle() {
        for (int i=0; i<3; i++) {
            List<String> shuffled = Randoms.shuffle(crewList.get(0).getStudentList());
            if (checkSame(crewList.get(0).getLevel(),shuffled)) {
                View.printMatchingResult(shuffled);
                crewList.get(0).setStudentList(shuffled);
                break;
            }
        }
    }

    public static void start() throws IOException {

        String menu="";
        while (true) {
            menu = inputMenu();
            if (menu.equals("Q")) {
                break;
            }
            fairMatching();
        }
    }

}

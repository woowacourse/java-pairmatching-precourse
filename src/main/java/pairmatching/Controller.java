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

    public static String inputMenu() {
        return View.inputMenu();
    }

    public void fairMatching() {

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

    public static void shuffle() {
        List<String> shuffled = Randoms.shuffle(crewList.get(0).getStudentList());
        View.printMatchingResult(shuffled);
        crewList.get(0).setStudentList(shuffled);
    }

    public static void start() throws IOException {
        String menu = inputMenu();
        String[] course = View.selectCourse().split(", ");
        makeCrew(course);
        System.out.println(crewList.get(0).getCourse().getName());
        System.out.println(crewList.get(0).getName());
        System.out.println(crewList.get(0).getLevel().getName());
        shuffle();
    }

}

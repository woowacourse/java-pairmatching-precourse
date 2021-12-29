package pairmatching;

public class PrintService {
    private LevelService levelService = new LevelService();
    private CourseService courseService = new CourseService();

    public void printWithMessage(String message) {
        System.out.println(message);
    }

    public void printCourse() {
        System.out.println(courseService.getCourseList());
    }

    public void printMission() {
        System.out.println(levelService.getMissionList());
    }
}

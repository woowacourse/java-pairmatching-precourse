package pairmatching;

public class ValidateService {
    private PrintService printService = new PrintService();
    private FunctionService functionService = new FunctionService();
    private LevelService levelService = new LevelService();
    private CourseService courseService = new CourseService();

    public boolean isValidateMission(String input) {
        String[] parsedInput = input.replace(" ", "").split(",");
        try {
            courseService.isExistCourse(parsedInput[0]);
            levelService.isExistMission(parsedInput[1], parsedInput[2]);
            return true;
        } catch (IllegalArgumentException e) {
            printService.printWithMessage(e.getMessage());
            return false;
        }
    }
}

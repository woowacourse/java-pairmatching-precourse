package pairmatching;

public class ValidateService {
    private PrintService printService = new PrintService();
    private FunctionService functionService = new FunctionService();
    private LevelService levelService = new LevelService();
    private CourseService courseService = new CourseService();

    public boolean isValidOption(String input) {
        try {
            functionService.isExistOption(input);
//            isUnique(input);
            return true;
        } catch (IllegalArgumentException e) {
            printService.printWithMessage(e.getMessage());
            return false;
        }
    }

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

//    private void isUnique(String input) throws IllegalArgumentException {
//        int nameIdx = isUniqueName(input);
//        int optionIdx = isUniqueOption(input);
//        if (nameIdx != -1 && optionIdx != -1) {
//            throw new IllegalArgumentException("[ERROR] 목록에 있는 하나의 옵션만 입력해 주세요.");
//        }
//        if (nameIdx == -1 && optionIdx == -1) {
//            throw new IllegalArgumentException("[ERROR] 목록에 있는 옵션을 입력해 주세요.");
//        }
//        setIndex(nameIdx, optionIdx);
//    }

//    private int isUniqueName(String input) {
//        int count = 0;
//        int index = 0;
//        for (int i = 0; i < functionNameList.size(); i++) {
//            if (input.contains(functionNameList.get(i))) {
//                count ++;
//                index = i;
//            }
//        }
//        if (count > 1) {
//            System.out.println("두개 이상 이름");
//            return -1;
//        }
//        return index;
//    }

//    private int isUniqueOption(String input) throws IllegalArgumentException {
//        int count = 0;
//        int index = 0;
//        for (int i = 0; i < functionOptionList.size(); i++) {
//            if (input.contains(functionOptionList.get(i))) {
//                count ++;
//                index = i;
//            }
//        }
//        if (count == 0) {
//            return -1;
//        }
//        return index;
//    }
}

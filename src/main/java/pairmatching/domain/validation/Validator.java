package pairmatching.domain.validation;

import java.util.List;
import java.util.StringTokenizer;

import pairmatching.domain.Mission;

public class Validator {
    private final int EMPTY_INPUT = 0;
    private Exception exception;

    public Validator(Exception exception) {
        this.exception = exception;
    }

    private void checkEmptyInput(String input) {

        if (input.trim().length() == EMPTY_INPUT) {
            exception.throwException(ErrorMessage.EMPTY_INPUT);
        }

    }

    private void checkMenuChoice(String menu) {

        if (!menu.matches(Text.REGEX_MENU)) {
            exception.throwException(ErrorMessage.WRONG_CHOICE);
        }

    }

    private void checkInformationForm(String information) {

        if (!information.matches(Text.REGEX_INFORMATION)) {
            exception.throwException(ErrorMessage.INFORMATION_FORM);
        }

    }

    private void checkCourse(String course) {
        if (!(course.equals(Text.BACKEND) || course.equals(Text.FRONTEND))) {
            exception.throwException(ErrorMessage.INFORMATION_COURSE);
        }
    }

    private void checkExistMission(String information, List<Mission> missionList) {
        StringTokenizer tokens = new StringTokenizer(information, Text.SEPARATOR);
        checkCourse(tokens.nextToken());
        String level = tokens.nextToken();
        String missionName = tokens.nextToken();

        for (int i = 0; i < missionList.size(); i++) {
            Mission mission = missionList.get(i);

            if (!(mission.getLevelString().equals(level) && mission.getName().equals(missionName))) {
                exception.throwException(ErrorMessage.NOT_EXISTS_MISSION);
            }

        }
    }

    public void isValidMenuChoice(String menu) {
        checkEmptyInput(menu);
        checkMenuChoice(menu);
    }

    public void isValidInformationInput(String information, List<Mission> missionList) {
        checkEmptyInput(information);
        checkInformationForm(information);
        checkExistMission(information, missionList);
    }
}

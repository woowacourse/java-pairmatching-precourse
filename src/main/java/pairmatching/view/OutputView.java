package pairmatching.view;

import pairmatching.domain.Level;

import static pairmatching.constants.FormatConstants.*;

public class OutputView {

    public static void showBackgroundInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(DIVIDER);
        sb.append(COURSES);
        sb.append(MISSION);
        for (Level level : Level.values()) {
            sb.append(MISSION_FORMAT(level));
        }
        sb.append(DIVIDER);
        System.out.println(sb);
    }
}

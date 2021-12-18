package pairmatching.view;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Missions;

public class OutputViews {
    public static void printMissionInfo(Missions missions) {
        System.out.println("\n#############################################");
        System.out.print("과정: ");
        System.out.println(String.join(" | ", Course.getList()));
        for (Level level : Level.getList()) {
            System.out.print("  - " + level.getName() + ": ");
            System.out.println(String.join(" | ", missions.getValue(level)));
        }
        System.out.println("#############################################");
    }
}

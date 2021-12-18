package pairmatching.view;

import pairmatching.controller.MatchingController;
import pairmatching.domain.Level;
import pairmatching.domain.course.Course;
import pairmatching.domain.mission.MissionName;
import pairmatching.util.io.IOProvider;

public class Matching {
    public static void play() {
        boolean keep = true;

        while (keep) {
            try {
                char c = start();
                keep = whatTodo(c);
            } catch (IllegalArgumentException e) {
                IOProvider.print(e.getMessage());
                continue;
            }
        }
    }

    private static boolean whatTodo(char c) {
        int count = 0;
        if (c == '1') {
            boolean keep = true;
            while(keep) {
                if(count == 0) {
                    keep = doMatch(matching());
                    count++;
                }
                if(count != 0)
                    keep = doMatch(rematching());
            }
            return true;
        }
        if (c == '2') {
            String[] matching = matching();
            IOProvider.printMatchingResult(MatchingController.getMissionResult(MissionName.isEqualName(matching[2])));
            return true;
        }
        if (c == '3') {
            return true;
        }
        return false;
    }


    private static void makeMission(String[] arr) {
        Course course = Course.valueOf(arr[0]);
        MatchingController.makeMission(course,
                Level.valueOf(arr[1]),
                MissionName.valueOf(arr[2]),
                course.getNameList());
    }
    private static boolean doMatch(String[] arr) {
        if (MatchingController.hasMission(MissionName.valueOf(arr[2]))) {
            if(IOProvider.printAlreadyMatched()) {
                MatchingController.removeMission(MissionName.valueOf(arr[2]));
                makeMission(arr);
                return false;
            }
            return true;
        }
        makeMission(arr);
        printMatchingResult(MatchingController.getMissionResult(MissionName.valueOf(arr[2])));
        return false;
    }

    private static char start() {
        return IOProvider.chooseWhatToDo();
    }

    private static String[] matching() {
        return IOProvider.chooseWhatMissionToDo();
    }


    private static String[] rematching() {
        return IOProvider.rechooseWhatMissionToDo();
    }

    private static void printMatchingResult(String result) {
        IOProvider.printMatchingResult(result);
    }
}

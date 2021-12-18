package pairmatching;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

import inputcontroller.inputValidator;
import inputcontroller.modelGenerator;
import models.Crew;
import models.Pair;

import static inputcontroller.inputGenerator.courseTypeInput;


public class MatchMain {

    public static void initMatch() {
        if (!modelGenerator.readFromDisk()) {
            return;
        }
        Crew.initBackMatch();
        Crew.initFrontMatch();
        inputValidator.initLevel2Missions();
    }

    public static void doFunction(int type) {
        if (type == 1) {
            pairMatch(courseTypeInput[0]);
            return;
        }
        if (type == 2) {
            pairPrint();
            return;
        }
        if (type == 3) {
            pairInit();
            return;
        }
    }

    public static void pairMatch(int type) {
        int cnt = 3;
        boolean flag = false;
        while (cnt != 0) {
            if (Crew.shuffleCrew(type)) {
                flag = true;
                break;
            }
            cnt--;
        }

        if (!flag) {
            throw new IllegalArgumentException("[ERROR] 매칭 안 됨\n");
        }
    }
}

package pairmatching.mode;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.Course;
import pairmatching.Level;

public class PairMatching implements PairMatchingService {

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(GuidanceMessage.GUIDE);
                String string = Console.readLine();
                String[] split = string.split(",");
                String course = Course.findByCourse(split[0].trim());
                String level = Level.findByLevel(split[1].trim());
                String mission = split[2].trim();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }

    }
}

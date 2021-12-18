package pairmatching.view;

import pairmatching.util.Symbol;
import pairmatching.view.message.ViewMessage;

public class PairMatchingOutputView {

    public void outputMatchingInfo(String course, String mission) {
        StringBuilder output = new StringBuilder();

        output.append(Symbol.NEW_LINE).append(ViewMessage.OUTPUT_HASH_LINE.getMessage()).append(Symbol.NEW_LINE);
        output.append(ViewMessage.OUTPUT_COURSE.getMessage()).append(course).append(Symbol.NEW_LINE);
        output.append(ViewMessage.OUTPUT_MISSION.getMessage()).append(Symbol.NEW_LINE);
        output.append(mission).append(Symbol.NEW_LINE).append(ViewMessage.OUTPUT_HASH_LINE.getMessage());
        System.out.println(output);
    }
}

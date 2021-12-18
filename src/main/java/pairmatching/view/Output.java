package pairmatching.view;

import java.util.List;

import pairmatching.model.Pair;
import pairmatching.util.Constant;
import pairmatching.util.Message;

public class Output {

    private Output() {
    }

    public static void guideMessage(String message) {
        System.out.println(message);
    }

    public static void errorMessage(String errorMessage) {
        System.out.println(String.format(Constant.ERROR_FORMAT, Message.ERROR, errorMessage));
    }

    public static void pairPrint(List<Pair> list) {
        StringBuilder sb = new StringBuilder();
        sb.append(Message.RESULT_PRINT).append("\n");
        for (Pair pair : list) {
            sb.append(pair.toString()).append("\n");
        }
        System.out.println(sb);
    }
}

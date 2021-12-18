package pairmatching;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.mode.Command;
import pairmatching.mode.PairMatchingService;

public class PairMatchingRunner implements Runnable {
    private static final String EXIT = "Q";
    @Override
    public void run() {
        inputMode();
    }

    private void inputMode() {
        while (true) {
            try {
                System.out.println("기능을 선택하세요.\n"
                    + "1. 페어 매칭\n"
                    + "2. 페어 조회\n"
                    + "3. 페어 초기화\n"
                    + "Q. 종료");
                String inputCommand = Console.readLine();
                if (inputCommand.equals(EXIT)) {
                    break;
                }
                PairMatchingService service = Command.findServiceByCommand(inputCommand);
                service.run();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}

package pairmatching.view;

import pairmatching.domain.crew.Crew;
import pairmatching.view.message.Message;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class OutputView {

    public void printCommandGuide() {
        print(Message.COMMAND_GUIDE.getMessage());
    }

    public void printChoiceGuide() {
        print(Message.CHOICE_GUIDE.getMessage());
    }

    public void printMatchingResult(List<Set<Crew>> pairs) {
        print(Message.MATCHING_RESULT_GUIDE.getMessage());
        for (Set<Crew> pair : pairs) {
            String result = makeMatchingResultMessage(pair);
            print(result);
        }
    }

    private String makeMatchingResultMessage(Set<Crew> pair) {
        return pair.stream()
                .map(Crew::getName)
                .collect(Collectors.joining(Message.MATCHING_DELIMITER.getMessage())) + "\n";
    }

    public void printReMatchingGuide() {
        print(Message.RE_MATCHING_GUIDE.getMessage());
    }

    public void printInitializingMessage() {
        print(Message.INITIALIZING.getMessage());
    }

    public void printErrorMessage(String message) {
        print(message);
    }

    private void print(String message) {
        System.out.print(message);
    }
}

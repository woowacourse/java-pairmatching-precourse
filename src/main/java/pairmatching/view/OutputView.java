package pairmatching.view;

import pairmatching.domain.choice.item.Mission;
import pairmatching.domain.command.Command;
import pairmatching.view.message.CommandMessage;
import pairmatching.view.message.Message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void printCommandGuideMessage(Command[] commands) {
        print(Message.COMMAND_GUIDE.getMessage());
        List<String> commandMessages = makeCommandMessages(commands, CommandMessage.values());
        commandMessages.forEach(this::print);
    }

    private List<String> makeCommandMessages(Command[] commands, CommandMessage[] commandMessages) {
        List<String> messages = new ArrayList<>();
        for (int i = 0; i < commands.length; i++) {
            CommandMessage message = commandMessages[i];
            Command command = commands[i];
            messages.add(message.getFormattedMessage(command.getKey()));
        }
        return messages;
    }

    public void printChoiceGuideMessage(List<String> courses, List<String> levels, Mission[] missions) {
        String message = makeChoiceMessage(courses, levels, missions);
        print(message);
    }

    private String makeChoiceMessage(List<String> courses, List<String> levels, Mission[] missions) {
        List<String> messages = new ArrayList<>();
        messages.add(Message.DIVIDING_LINE.getMessage());
        messages.add(makeChoiceContentMessage(courses, levels, missions));
        messages.add(Message.DIVIDING_LINE.getMessage());
        messages.add(Message.CHOICE_GUIDE.getMessage());
        messages.add(Message.CHOICE_EXAMPLE.getMessage());
        return String.join(Message.NEW_LINE.getMessage(), messages);
    }

    private String makeChoiceContentMessage(List<String> courses, List<String> levels, Mission[] missions) {
        List<String> messages = new ArrayList<>();
        messages.add(Message.COURSE.getFormattedMessage(String.join(Message.DELIMITER.getMessage(), courses)));
        messages.add(Message.MISSION.getMessage());
        for (String level : levels) {
            String missionsOfLevel = makeMissionMessageByLevel(missions, level);
            messages.add(Message.LEVEL.getFormattedMessage(level, missionsOfLevel));
        }
        return String.join(Message.NEW_LINE.getMessage(), messages);
    }

    private String makeMissionMessageByLevel(Mission[] missions, String level) {
        return Arrays.stream(missions)
                .filter(mission -> level.equals(mission.getLevelMessage()))
                .map(Mission::getName)
                .collect(Collectors.joining(Message.DELIMITER.getMessage()));
    }

    public void printReMatchingGuide() {
        print(Message.RE_MATCHING_GUIDE.getMessage());
        print(Message.RE_MATCHING_EXAMPLE.getMessage());
    }

    public void print(String message) {
        System.out.print(message);
    }
}

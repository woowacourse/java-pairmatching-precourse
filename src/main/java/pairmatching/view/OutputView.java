package pairmatching.view;

import pairmatching.domain.program.command.Command;
import pairmatching.view.message.CommandMessage;
import pairmatching.view.message.Message;

import java.util.ArrayList;
import java.util.List;

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
            messages.add(message.getFormattedMessage(command.getCommand()));
        }
        return messages;
    }

    private void print(String message) {
        System.out.print(message);
    }
}

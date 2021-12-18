package pairmatching.io;

public class ConsoleOutputHandler {
	public void printMessage(String message) {
		System.out.println(message);
	}

	public void printErrorMessage(Exception exception) {
		printMessage(exception.getMessage());
	}

}

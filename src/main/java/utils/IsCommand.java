package utils;

public class IsCommand implements Validator {
	public boolean run(String input) {
		try {
			Commands.getCommandByKey(input);
		} catch (IllegalArgumentException error) {
			System.out.println(error);
			return true;
		}
		return false;
	}
}

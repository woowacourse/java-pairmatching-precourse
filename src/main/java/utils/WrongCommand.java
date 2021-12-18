package utils;

public class WrongCommand implements Validator {
	public boolean check(String input) {
		try {
			Commands.getCommandByKey(input);
		} catch (IllegalArgumentException error) {
			System.out.println(error);
			return true;
		}
		return false;
	}
}

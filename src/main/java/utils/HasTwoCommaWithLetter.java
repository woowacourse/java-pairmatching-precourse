package utils;

public class HasTwoCommaWithLetter implements Validator{
	public boolean run(String input) {
		String regex = ", ";
		int a = 0;
		int b = 0;
		if (input.contains(regex)) {
			a = input.indexOf(regex);
			b = input.lastIndexOf(regex);
		}
		return a != b;
	}
}

package utils;

public class WrongTwoCommaWithLetter implements Validator{
	public boolean check(String input) {
		String regex = ", ";
		int a = 0;
		int b = 0;

		if (input.contains(regex)) {
			a = input.indexOf(regex);
			b = input.lastIndexOf(regex);
		}

		if (a == b) {
			throw new IllegalArgumentException("[ERROR] 적절한 과정, 레벨, 미션 입력이 아닙니다.");
		}

		return false;
	}
}
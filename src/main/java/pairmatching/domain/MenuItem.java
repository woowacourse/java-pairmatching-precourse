package pairmatching.domain;

public class MenuItem {
	private final String number;
	private final String name;

	public MenuItem(String number, String name) {
		this.number = number;
		this.name = name;
	}

	public boolean isSameNumber(String number) {
		return this.number.equals(number);
	}

	@Override
	public String toString() {
		return number + ". " + name;
	}
}

package pairmatching.domain;

public class Mission {
	private String name;

	public Mission(String name) {
		this.name = name;
	}

	public boolean isSame( String name) {
		return this.name.equals(name);
	}
}

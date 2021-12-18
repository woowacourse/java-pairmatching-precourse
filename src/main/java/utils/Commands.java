package utils;

public enum Commands {
	PAIR_MATCH("1"),
	PAIR_CHECK("2"),
	PAIR_DELETE_ALL("3"),
	QUIT("Q");

	private final String key;

	Commands(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public static Commands getCommandByKey(String key) {
		for (Commands command : Commands.values()) {
			if (command.getKey().equals(key)) {
				return command;
			}
		}
		throw new IllegalArgumentException("[ERROR] 잘못된 명령입니다.");
	}
}

package pairmatching.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import pairmatching.constant.Notification;

public enum Function {

	PAIR_MATCHING('1', "페어 매칭"),
	PAIR_INQUIRY('2', "페어 조회"),
	PAIR_INITIALIZATION('3', "페어 초기화"),
	TERMINATION('Q', "종료");

	private static final Map<Character, Function> BY_KEY = new HashMap<>();

	static {
		for (Function function : values()) {
			BY_KEY.put(function.key, function);
		}
	}

	private final char key;
	private final String message;

	Function(char key, String message) {
		this.key = key;
		this.message = message;
	}

	@Override
	public String toString() {
		return key + ". " + message;
	}

	public static Function valueOf(char key) {
		if(BY_KEY.containsKey(key)) {
			return BY_KEY.get(key);
		}
		throw new IllegalArgumentException(Notification.NOT_SUPPORTED_FUNCTION.getMessage());
	}
}

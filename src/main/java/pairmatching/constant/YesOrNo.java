package pairmatching.constant;

import java.util.StringJoiner;

public enum YesOrNo {
	YES("예"),
	NO("아니오");

	private String name;

	YesOrNo(String name) {
		this.name = name;
	}

	public static String getSelfDescription() {
		StringJoiner joiner = new StringJoiner(" | ");
		for (YesOrNo yesOrNo : YesOrNo.values()) {
			joiner.add(yesOrNo.name);
		}
		return joiner.toString();
	}
}

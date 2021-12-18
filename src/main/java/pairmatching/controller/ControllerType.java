package pairmatching.controller;

import pairmatching.config.ControllerConfig;

public enum ControllerType {
	MATCH("1", ControllerConfig.getMatchController()),
	SEARCH("2", ControllerConfig.getSearchController()),
	CLEAR("3", ControllerConfig.getClearController()),
	QUIT("Q", null);

	private static final String ERROR = "해당하는 기능이 없습니다.";

	private String number;
	private Controller controller;

	ControllerType(String number, Controller controller) {
		this.number = number;
		this.controller = controller;
	}

	public static ControllerType of(String str) {
		for (ControllerType type : values()) {
			if (type.number.equals(str)) {
				return type;
			}
		}
		throw new IllegalArgumentException(ERROR);
	}

	public void controlAction() {
		controller.execute();
	}
}

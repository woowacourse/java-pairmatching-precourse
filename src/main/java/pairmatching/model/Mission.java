package pairmatching.model;

import java.util.Arrays;

public enum Mission {
	CAR("자동차경주"),
	LOTTO("로또"),
	BASEBALL("숫자야구게임"),
	IMPROVE("성능개선"),
	DISTRIBUTE("배포");

	private String name;

	Mission(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}

package pairmatching.domain;

import java.util.Arrays;
import java.util.List;

public enum Level {
	LEVEL1("레벨1") {
		@Override
		List<Mission> missions() {
			return Arrays.asList(Mission.from("자동차경주"), Mission.from("로또"), Mission.from("숫자야구게임"));
		}
	},
	LEVEL2("레벨2") {
		@Override
		List<Mission> missions() {
			return Arrays.asList(Mission.from("장바구니"), Mission.from("결제"), Mission.from("지하철노선도"));
		}
	},
	LEVEL3("레벨3") {
		@Override
		List<Mission> missions() {
			return Arrays.asList();
		}
	},
	LEVEL4("레벨4") {
		@Override
		List<Mission> missions() {
			return Arrays.asList(Mission.from("성능개선"), Mission.from("배포"));
		}
	},
	LEVEL5("레벨5") {
		@Override
		List<Mission> missions() {
			return Arrays.asList();
		}
	};

	private String name;

	Level(String name) {
		this.name = name;
	}

	abstract List<Mission> missions();

	public static Level from(String name) {
		return Arrays.stream(Level.values())
			.filter(level -> level.name.equals(name))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 레벨입니다."));
	}

}
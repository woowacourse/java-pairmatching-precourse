package pairmatching;

public enum Level {
	LEVEL1("레벨1", 1, new String[] {"자동차경주", "로또", "숫자야구게임"}),
	LEVEL2("레벨2", 2, new String[] {"장바구니", "결제", "지하철노선도"}),
	LEVEL3("레벨3", 3, new String[] {}),
	LEVEL4("레벨4", 4, new String[] {"성능개선, 배포"}),
	LEVEL5("레벨5", 5, new String[] {});

	private static final String FRONTEND_COURSE = "프론트엔드 과정";
	private static final String UNEXPECTED_ERROR = "[ERROR] 예상치 못한 에러가 발생했습니다.";

	private final String name;
	private final int level;
	private final Record frontEndRecord;
	private final Record backEndRecord;

	Level(String name, int level, String[] recordEntries) {
		this.name = name;
		this.level = level;
		frontEndRecord = new Record();
		backEndRecord = new Record();
		for (String entry : recordEntries) {
			frontEndRecord.push(entry, new PairList());
			backEndRecord.push(entry, new PairList());
		}
	}

	public Record getRecord(String course) {
		if (course.equals(FRONTEND_COURSE)) {
			return getFrontEndRecord();
		}
		return getBackEndRecord();
	}

	private Record getFrontEndRecord() {
		return frontEndRecord;
	}

	private Record getBackEndRecord() {
		return backEndRecord;
	}

	public static Level getLevel(int level) throws IllegalArgumentException {
		for (Level l : Level.values()) {
			if (l.level == level) {
				return l;
			}
		}
		throw new IllegalArgumentException(UNEXPECTED_ERROR);
	}

	// 추가 기능 구현
}

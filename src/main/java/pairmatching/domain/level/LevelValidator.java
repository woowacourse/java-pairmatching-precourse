package pairmatching.domain.level;

import pairmatching.domain.ErrorMessage;

public class LevelValidator {
    public void checkLevelName(String levelName) {
        for (Level level : Level.values()) {
            if (level.getName().equals(levelName)) {
                return;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.makeErrorMessage(
            "존재하지 않는 레벨입니다. 다시 입력해주세요."));
    }
}

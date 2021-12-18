package pairmatching.domain.level;

import java.util.Arrays;
import java.util.Objects;

import pairmatching.domain.level.enums.LevelEnum;

public class Level {
    public static final String NON_EXIST_EXCEPTION = "[ERROR] 존재하지 않는 레벨입니다.";
    private String level;

    public Level(String level) {
        validateLevel(level);
        this.level = level;
    }

    private void validateLevel(String level) {
        if (!existLevel(level)) {
            throw new IllegalArgumentException(NON_EXIST_EXCEPTION);
        }
    }

    private boolean existLevel(String inputLevel) {
        return Arrays.stream(LevelEnum.values()).anyMatch(level -> level.getLevel().equals(inputLevel));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Level level1 = (Level)o;
        return Objects.equals(level, level1.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(level);
    }
}

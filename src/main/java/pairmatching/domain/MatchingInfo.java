package pairmatching.domain;

import java.util.Objects;

public class MatchingInfo {

    private final Course course;
    private final Level level;
    private final String missionName;

    private MatchingInfo(final Course course, final Level level, final String missionName) {
        this.course = course;
        this.level = level;
        this.missionName = missionName;
    }

    public static MatchingInfo createMatchingInfo(String[] info) {
        Course course = Course.from(info[0].trim());
        Level.validateLevelAndMission(info[1], info[2]);
        return new MatchingInfo(course, Level.from(info[1]), info[2]);
    }


    public boolean equalsLevel(MatchingInfo info) {
        return this.level == info.level;
    }

    public Course getCourse() {
        return this.course;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (null == o || this.getClass() != o.getClass()) {
            return false;
        }
        final MatchingInfo that = (MatchingInfo) o;
        return this.course == that.course && this.level == that.level && this.missionName.equals(that.missionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.course, this.level, this.missionName);
    }
}

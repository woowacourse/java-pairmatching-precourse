package pairmatching.model;

import pairmatching.util.Constant;
import pairmatching.util.Message;

public class Options {
    private final Course course;
    private final Level level;
    private final Mission mission;

    public Options(String options) {
        validOptions(options);
        String[] option = splitOptions(options);
        this.course = Course.parseCourse(option[Constant.OPTION_COURSE_ARRAY_INDEX]);
        this.level = Level.parseLevel(option[Constant.OPTION_LEVEL_ARRAY_INDEX]);
        this.mission = new Mission(Level.parseMission(level, option[Constant.OPTION_MISSION_ARRAY_INDEX]));
    }

    private String[] splitOptions(String options) {
        String[] option = options.split(Constant.OPTION_DELIMITER);

        for (int i = 0; i < option.length; i++) {
            option[i] = option[i].trim();
        }
        return option;
    }

    private void validOptions(String options) {
        if (splitOptions(options).length != Constant.OPTION_ARRAY_SIZE) {
            throw new IllegalArgumentException(Message.OPTIONS_ERROR);
        }
    }
}

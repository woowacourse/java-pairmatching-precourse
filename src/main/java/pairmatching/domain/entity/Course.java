package pairmatching.domain.entity;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import pairmatching.util.ExceptionUtil;
import pairmatching.util.FileUtil;

public enum Course {
    BACKEND("백엔드", "backend-crew.md"),
    FRONTEND("프론트엔드", "frontend-crew.md");

    private final String description;
    private final String filePath;

    Course(final String description, final String filePath) {
        this.description = description;
        this.filePath = filePath;
    }

    public static Course findCourse(String courseName) {
        return Arrays.stream(values())
                .filter(course -> course.description.equals(courseName))
                .findAny()
                .orElseThrow(() -> ExceptionUtil.returnInvalidValueException());
    }


    public List<String> getCrews() {
        try {
            return FileUtil.readFileAsList(getFilePath());
        } catch (IOException e) {
            throw ExceptionUtil.returnInvalidValueException();
        } catch (URISyntaxException e) {
            throw ExceptionUtil.returnInvalidValueException();
        }
    }

    public String getDescription() {
        return description;
    }

    public String getFilePath() throws URISyntaxException {
        return Paths.get(getClass()
                .getClassLoader()
                .getResource(filePath)
                .toURI()).toString();
    }


}
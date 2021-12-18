package pairmatching.model.information;

import java.util.ArrayList;
import java.util.List;

public class CourseInformation {

    private final String[] selectCourseInformation;

    public CourseInformation(final String[] selectCourseInformation) {
        this.selectCourseInformation = selectCourseInformation;
    }

    public List<String> removeTrim() {
        final List<String> courseInformation = new ArrayList<>();

        for (String eachInformation:selectCourseInformation) {
            courseInformation.add(eachInformation.trim());
        }

        return courseInformation;
    }

}

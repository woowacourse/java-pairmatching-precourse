package pairmatching.model.information;

import java.util.ArrayList;
import java.util.List;

public class CourseInformation {
    private String[] selectCourseInformation;

    public CourseInformation(final String[] selectCourseInformation) {
        this.selectCourseInformation = selectCourseInformation;
    }

    public List<String> createCourseInformationList() {
        final List<String> courseInformation = new ArrayList<>();

        for (String eachCourseInformation : selectCourseInformation) {
            courseInformation.add(eachCourseInformation.trim());
        }

        return courseInformation;
    }

}

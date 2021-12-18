package pairmatching.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pairmatching.model.domain.Course;
import pairmatching.util.Constant;

public class FileScanner {

    public List<String> nameFileScanner(Course course) {
        List<String> crewNames = new ArrayList<>();
        try {
            File file = courseToFile(course);
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                crewNames.add(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
        }
        return crewNames;
    }

    private File courseToFile(Course course) {
        if (course == Course.BACKEND) {
            return new File(Constant.BACK_COURSE_SRC);
        }
        return new File(Constant.FRONT_COURSE_SRC);
    }
}

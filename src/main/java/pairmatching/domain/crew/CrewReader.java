package pairmatching.domain.crew;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.ErrorMessage;
import pairmatching.domain.course.Course;

public class CrewReader {
    private final String READER_ERROR = "파일을 이어오는데 문제가 발생하였습니다.";

    public List<Crew> readCrewOfCourse(Course course) {
        ArrayList<Crew> crewList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(course.getSourceFileName()));
            String name;
            while ((name = reader.readLine()) != null) {
                crewList.add(new Crew(name, course));
            }
            reader.close();
        } catch (IOException exception) {
            throw new IllegalArgumentException(ErrorMessage.makeErrorMessage(READER_ERROR));
        }
        return crewList;
    }
}

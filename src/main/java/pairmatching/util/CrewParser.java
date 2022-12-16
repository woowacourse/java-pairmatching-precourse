package pairmatching.util;

import pairmatching.domain.match.Course;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrewParser {
    public List<String> parseCrewData(Course course) {
        List<String> crews = new ArrayList<>();
        try {
            if (course == Course.BACKEND) {
                crews = parse("backend-crew.md");
            } else if (course == Course.FRONTEND) {
                crews = parse("frontend-crew.md");
            }
        } catch (IOException error) {
        }

        return crews;
    }

    private List<String> parse(String fileName) throws IOException {
        List<String> crews = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/" + fileName));
        while (true) {
            String crew = br.readLine();
            if (crew == null) break;  // 더 이상 읽을 라인이 없을 경우 while 문을 빠져나간다.
            crews.add(crew);
        }
        br.close();

        return crews;
    }
}

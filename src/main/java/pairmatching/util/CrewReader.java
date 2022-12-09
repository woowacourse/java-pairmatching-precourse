package pairmatching.util;

import pairmatching.domain.Course;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class CrewReader {
    private static final String DEFAULT_PATH = "src/main/resources/";
    private static final String BACKEND_FILE = "backend-crew.md";
    private static final String FRONTEND_FILE = "frontend-crew.md";

    public static List<String> readCrewMembers(Course course) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(makePath(course)));
        List<String> members = new ArrayList<>();
        while(true){
            String name = reader.readLine();
            if (name==null) break;
            members.add(name.trim());
        }
        reader.close();
        return members;
    }

    private static String makePath(Course course){
        StringBuilder path = new StringBuilder(DEFAULT_PATH);
        if(Course.BACKEND.equals(course)){
            return path.append(BACKEND_FILE).toString();
        }
        return path.append(FRONTEND_FILE).toString();
    }
}

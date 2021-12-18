package pairmatching.source;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCrewFile {
    private static final String BACKEND_FILE_ROUTE = "src/main/resources/backend-crew.md";
    private static final String FRONTEND_FILE_ROUTE = "src/main/resources/frontend-crew.md";
    private static final String NO_ROUTE_ERROR_MESSAGE = "지정된 경로를 찾을 수 없습니다.";

    public static List<String> getBackEndCrewNames(){
        List<String> crewNames;

        try {
            crewNames = readCrewNamesByRoute(BACKEND_FILE_ROUTE);
        }catch(IOException exception){
            System.out.println(NO_ROUTE_ERROR_MESSAGE);
            return null;
        }

        return crewNames;
    }

    public static List<String> getCrewNamesByCourse(Course course){
        if(course ==Course.BACKEND){
            return getBackEndCrewNames();
        }

        return getFrontEndCrewNames();
    }

    public static List<String> getFrontEndCrewNames(){
        List<String> crewNames;

        try {
            crewNames = readCrewNamesByRoute(FRONTEND_FILE_ROUTE);
        }catch(IOException exception){
            System.out.println(NO_ROUTE_ERROR_MESSAGE);
            return null;
        }

        return crewNames;
    }

    private static List<String> readCrewNamesByRoute(String route) throws IOException {
        BufferedReader crewReader = new BufferedReader(new FileReader(route));
        List<String> crewNames = new ArrayList<>();

        String name;
        while((name = crewReader.readLine()) != null){
            crewNames.add(name);
        }

        return crewNames;
    }
}

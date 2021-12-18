package pairmatching.matching;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MatchingFileInput {
    String backendFilePath = "src/main/resources/backend-crew.md";
    String frontendFilePath = "src/main/resources/frontend-crew.md";

    BufferedReader backBr;
    BufferedReader frontBr;

    List<String> backendPeople;
    List<String> frontendPeople;

    public MatchingFileInput() throws IOException {
        backBr = new BufferedReader(new FileReader(backendFilePath));
        frontBr = new BufferedReader(new FileReader(frontendFilePath));
        backendPeople = new ArrayList<>();
        frontendPeople = new ArrayList<>();
    }

    public List<String> returnBackendPeople() throws IOException {
        while (true) {
            String name = backBr.readLine();
            if (name == null) {
                break;
            }
            backendPeople.add(name);
        }
        return backendPeople;
    }

    public List<String> returnFrontendPeople() throws IOException {
        while (true) {
            String name = frontBr.readLine();
            if (name == null) {
                break;
            }
            frontendPeople.add(name);
        }
        return frontendPeople;
    }
}

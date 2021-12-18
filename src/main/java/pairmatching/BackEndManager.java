package pairmatching;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BackEndManager {
    private ArrayList<Crew> backEndCrewList;

    public BackEndManager() {
        InputFile inputFile = InputFile.getInstance();
        ArrayList<String> userNameList = inputFile.getBackEndUserData();
        List<Crew> userList = userNameList.stream()
                .map((username) -> new Crew(username))
                .collect(Collectors.toList());
        backEndCrewList = new ArrayList<Crew>(userList);
    }
}

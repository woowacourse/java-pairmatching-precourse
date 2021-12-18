package pairmatching;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FrontEndManager {
    private ArrayList<Crew> FrontEndCrewList;

    public FrontEndManager() {
        InputFile inputFile = InputFile.getInstance();
        ArrayList<String> userNameList = inputFile.getFrontEndUserData();
        List<Crew> userList = userNameList.stream()
                .map((username) -> new Crew(username))
                .collect(Collectors.toList());
        FrontEndCrewList = new ArrayList<Crew>(userList);
    }

    public ArrayList<Crew> getFrontEndCrewList() {
        return FrontEndCrewList;
    }
}

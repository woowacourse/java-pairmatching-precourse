package pairmatching;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CrewManager {
    private ArrayList<Crew> frontEndCrewList;
    private ArrayList<Crew> backEndCrewList;

    List<Crew> getUserList(ArrayList<String> userNameList) {
        List<Crew> userList = userNameList.stream()
                .map((username) -> new Crew(username))
                .collect(Collectors.toList());
        return userList;
    }

    public CrewManager() {
        FileInput inputFile = FileInput.getInstance();
        ArrayList<String> frontUserNameList = inputFile.getFrontEndUserData();
        ArrayList<String> backUserNameList = inputFile.getBackEndUserData();
        frontEndCrewList = new ArrayList<Crew>(getUserList(frontUserNameList));
        backEndCrewList = new ArrayList<Crew>(getUserList(backUserNameList));
    }

    public ArrayList<Crew> getBackEndCrewList() {
        return backEndCrewList;
    }

    public ArrayList<Crew> getFrontEndCrewList() {
        return frontEndCrewList;
    }
}

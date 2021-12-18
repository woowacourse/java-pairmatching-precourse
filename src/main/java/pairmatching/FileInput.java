package pairmatching;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FileInput {
    private static final String BACKEND_PATH = "src/main/resources/backend-crew.md";
    private static final String FRONTEND_PATH = "src/main/resources/frontend-crew.md";
    private static final String INVALID_PATH_ERROR = "잘못된 경로입니다.";
    private static FileInput inputFile = null;

    private FileInput() {}

    public static FileInput getInstance() {
        if (inputFile == null) {
            inputFile = new FileInput();
        }
        return inputFile;
    }

    public void setUserData(ArrayList<String> targetList, String fileName) {
        try {
            Scanner scanner = new Scanner(new File(fileName));

            while (scanner.hasNext()) {
                targetList.add(new String(scanner.nextLine().trim()));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_PATH_ERROR);
        }
    }

    public ArrayList<String> getFrontEndUserData() {
        ArrayList<String> frontEndUserList = new ArrayList<String>();
        setUserData(frontEndUserList, FRONTEND_PATH);
        return frontEndUserList;
    }

    public ArrayList<String> getBackEndUserData() {
        ArrayList<String> backEndUserList = new ArrayList<String>();
        setUserData(backEndUserList, BACKEND_PATH);
        return backEndUserList;
    }
}

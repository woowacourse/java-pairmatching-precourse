package pairmatching.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtility {
    private static class LazyHolder {
        public static final FileUtility INSTANCE = new FileUtility();
    }

    public static FileUtility getInstance() {
        return FileUtility.LazyHolder.INSTANCE;
    }

    public List<String> readToListFromREADME(String jobGroup) {
        List<String> names = new ArrayList<>();
        try {
            File file = new File("C:\\Users\\USER\\IdeaProjects\\java-pairmatching-precourse\\src\\main\\resources\\" + jobGroup);
            FileReader filereader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(filereader);
            String name = "";
            while ((name = bufReader.readLine()) != null) {
                names.add(name);
            }
            bufReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return names;
    }
}

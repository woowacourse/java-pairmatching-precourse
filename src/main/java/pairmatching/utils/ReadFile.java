package pairmatching.utils;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    static String backendFilePath = "D:\\java-pairmatching-precourse\\src\\main\\resources\\backend-crew.md";

    public static String ReadFile(String path){

        File file = new File(backendFilePath);
        try {
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                return scan.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return path;
    }
}

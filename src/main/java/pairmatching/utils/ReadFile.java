package pairmatching.utils;


import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class ReadFile {

    public static List<String> readFile(String path){

        String url = ReadFile.class.getResource(".").getPath();
        File file = new File(url+"backend-crew.txt");

        List<String> allNames = new ArrayList<String>() ;
        try {
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                allNames.add(scan.nextLine());
            }
            return allNames;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}

package pairmatching.utils;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class ReadFile {

    public static String readFile(String path){

        File file = new File(path);
        List<String> allNames = new ArrayList<String>() ;
        try {
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                allNames.add(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return path;
    }
}

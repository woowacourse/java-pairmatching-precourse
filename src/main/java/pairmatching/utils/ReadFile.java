package pairmatching.utils;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class ReadFile {

    public static List<String> readFile(String path){
        System.out.println(path);
        File file = new File(path);
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

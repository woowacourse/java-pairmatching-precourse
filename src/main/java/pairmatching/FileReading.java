package pairmatching;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReading {
    static String filepath = "src\\main\\resources\\";
    static String frontFileName = "frontend-crew.md";
    static String backFileName = "backend-crew.md";
    
    public static List<String> frontCrewReading() {
    	List<String> lines = null;
    	try {
    	    Path path = Paths.get(filepath + frontFileName);
    	    lines = Files.readAllLines(path);
//    	    for(String line : lines) {
//    	        System.out.println(line);
//    	    }
    	} catch (IOException e) {
    	    e.printStackTrace();
    	}

    	return lines;
    }
    
    public static List<String> backCrewReading() {
    	List<String> lines = null;
    	try {
    	    Path path = Paths.get(filepath + backFileName);
    	    lines = Files.readAllLines(path);
//    	    for(String line : lines) {
//    	        System.out.println(line);
//    	    }
    	} catch (IOException e) {
    	    e.printStackTrace();
    	}

    	return lines;
    }
}

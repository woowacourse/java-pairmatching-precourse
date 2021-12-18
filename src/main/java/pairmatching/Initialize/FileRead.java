package pairmatching.Initialize;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileRead {
    public static BufferedReader fileRead(String name) throws FileNotFoundException {
        return new BufferedReader(
                new FileReader(name)
        );
    }
}

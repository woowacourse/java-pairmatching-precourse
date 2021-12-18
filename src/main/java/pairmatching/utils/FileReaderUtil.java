package pairmatching.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Crew;
import pairmatching.dto.CrewDto;

public class FileReaderUtil {

    public static List<CrewDto> addCrewByFile(String filePath) throws IOException {
        List<CrewDto> crewDtos = new ArrayList<>();
        File file = new File(filePath);
        FileReader filereader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(filereader);
        String name = "";
        while((name = bufferedReader.readLine()) != null){
            crewDtos.add(new CrewDto(name));
        }
        bufferedReader.close();
        return crewDtos;
    }
}

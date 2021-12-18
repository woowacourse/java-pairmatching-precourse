package pairmatching.domain;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.dto.CrewDto;
import pairmatching.utils.FileReaderUtil;

public class FrontCrews {
    private static List<Crew> crews;

    static {
        String filePath = "/Users/anyoungyoon/Desktop/woowacourse/java-pairmatching-precourse/src/main/resources/frontend-crew.md";
        try {
            List<CrewDto> crewDtos = FileReaderUtil.addCrewByFile(filePath);
            crews = crewDtos.stream().map(crewDto -> new Crew(Course.FRONTEND, crewDto.getName())).collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalArgumentException("[ERROR] 프론트엔드 크루이름 파일을 확인해주세요.");
        }
    }


}

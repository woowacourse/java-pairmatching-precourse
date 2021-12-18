package pairmatching;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.view.View;
import pairmatching.view.Menu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PairMatchingController {

    public static final String BACKEND_CREW_NAMES = "src/main/resources/backend-crew.md";
    public static final String FRONTEND_CREW_NAMES = "src/main/resources/frontend-crew.md";

    public void run() {
        Menu menu;
        do {
            menu = View.getMenu();
            execute(menu);
        } while (menu != Menu.QUIT);
    }

    private void execute(Menu menu) {
        if (menu == Menu.PAIR_MATCHING) {
            // TODO: 2021/12/18 페어 매칭 기능 구현
            View.printBoard();


        }
        if (menu == Menu.PAIR_SEARCH) {
            // TODO: 2021/12/18 페어 조회 기능 구현
        }
        if (menu == Menu.PAIR_CLEAR) {
            // TODO: 2021/12/18 페어 초기화 기능 구현
        }
    }


    private List<Crew> loadCrews(Course course) {
        if (course == Course.BACKEND) {
            List<String> backendCrewNames = loadBackendCrewName()
                    .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 파일이 존재하지 않습니다."));
            return backendCrewNames.stream()
                    .map(name -> new Crew(Course.BACKEND, name))
                    .collect(Collectors.toList());
        }

        if (course == Course.FRONTEND) {
            List<String> frontendCrewNames = loadFrontendCrewName()
                    .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 파일이 존재하지 않습니다."));
            return frontendCrewNames.stream()
                    .map(name -> new Crew(Course.FRONTEND, name))
                    .collect(Collectors.toList());
        }

        throw new IllegalArgumentException("[ERROR] 크루 생성에 실패했습니다.");
    }


    private Optional<List<String>> loadBackendCrewName() {
        try {
            Path path = Paths.get(BACKEND_CREW_NAMES);
            List<String> crewNames = Files.readAllLines(path);
            return Optional.of(crewNames);
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    private Optional<List<String>> loadFrontendCrewName() {
        try {
            Path path = Paths.get(FRONTEND_CREW_NAMES);
            List<String> crewNames = Files.readAllLines(path);
            return Optional.of(crewNames);
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}

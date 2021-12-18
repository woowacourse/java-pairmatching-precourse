package pairmatching;

import pairmatching.model.Course;
import pairmatching.model.Crew;
import pairmatching.model.Level;

import java.io.*;

public class InitialSetting {
    private static final String FILE_PATH = "src/main/resources/";
    private static final String BACKEND = "백엔드";
    private static final String FRONTEND = "프론트엔드";
    private static final String BACKEND_FILENAME = "backend-crew.md";
    private static final String FRONTEND_FILENAME = "frontend-crew.md";

    public void initialInformation() {
        Level.LEVEL1.addMission("자동차경주");
        Level.LEVEL1.addMission("로또");
        Level.LEVEL1.addMission("숫자야구게임");
        Level.LEVEL2.addMission("장바구니");
        Level.LEVEL2.addMission("결제");
        Level.LEVEL2.addMission("지하철 노선도");
        Level.LEVEL4.addMission("성능개선");
        Level.LEVEL4.addMission("배포");
    }

    public void fileInput() {
        Course course = null;
        try {
            FileReader fileReader = new FileReader(FILE_PATH + "backend-crew.md");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String readLine = null;
            while ((readLine = bufferedReader.readLine()) != null) {
                if (readLine.equals("백엔드")) {
                    course = Course.valueOf("백엔드");
                }
                Crew crew = new Crew(readLine);
                course.addCrew(crew);
            }
        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

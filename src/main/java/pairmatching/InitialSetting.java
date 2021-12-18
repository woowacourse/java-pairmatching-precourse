package pairmatching;

import pairmatching.model.Course;
import pairmatching.model.Crew;
import pairmatching.model.Level;

import java.io.*;

public class InitialSetting {
    private static final String FILE_PATH = "src/main/resources/";
    private static final String BACKEND = "BACKEND";
    private static final String FRONTEND = "FRONTEND";
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

    // 1. 디렉토리에 파일명 가져오기
    public void getFileNameInDirectory() {
        File dir = new File(FILE_PATH);
        String[] fileNames = dir.list();
        for (String fileName : fileNames) {
            fileInput(fileName);
        }
    }


    // 2. 해당 파일 읽기 
    public void fileInput(String fileName) {
        Course course = null;
        if (fileName.equals(BACKEND_FILENAME)) {
            course = Course.valueOf(BACKEND);
        }
        if (fileName.equals(FRONTEND_FILENAME)) {
            course = Course.valueOf(FRONTEND);
        }
        try {
            FileReader fileReader = new FileReader(FILE_PATH + fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String readLine = null;
            while ((readLine = bufferedReader.readLine()) != null && course != null) {
                Crew crew = new Crew(readLine);
                course.addCrew(crew);
            }
//            printCourse(course);
        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // test용 출력 코드
//    public void  printCourse(Course  course){
//        for(Crew crew : course.getCrewList()){
//            System.out.println(crew.getName());
//        }
//    }

}

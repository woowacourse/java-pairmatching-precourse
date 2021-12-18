package pairmatching;



import java.util.List;
import java.util.ArrayList;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import camp.nextstep.edu.missionutils.Randoms;

public class Crews {
    final int COURSES = 16;
    List<String> backendCrewNames = new ArrayList<>();
    List<String> frontendCrewNames = new ArrayList<>();
    ArrayList<List<String>> pairsBackend = new ArrayList<>();
    ArrayList<List<String>> pairsFrontend = new ArrayList<>();
    List<String> temp = new ArrayList<>();

    int courseIndex;
    String position;
    final int LEVEL1_CarRACING = 0;
    final int LEVEL1_LOTTO = 1;
    final int LEVEL1_BASEBALL = 2;
    final int LEVEL2_BASKET = 3;
    final int LEVEL2_PAYMENT = 4;
    final int LEVEL2_SUBWAY = 5;
    final int LEVEL4_PERFORMANCE = 6;
    final int LEVEL4_STREAM = 7;


    public void createCourses() {
        for (int i = 0; i < COURSES / 2; i++) {
            pairsBackend.add(new ArrayList<>());
        }
        for (int i = 0; i < COURSES / 2; i++) {
            pairsFrontend.add(new ArrayList<>());
        }
    }

    public void readBackend() {
        try {
            File backend = new File("C:\\Users\\woowahan\\Desktop\\java-pairmatching-precourse\\src\\main\\resources\\backend-crew.md");
            FileReader filereader = new FileReader(backend);
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            while ((line = bufReader.readLine()) != null) {
                backendCrewNames.add(line);
            }
            bufReader.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void readFrontend() {
        try {
            File frontend = new File("C:\\Users\\woowahan\\Desktop\\java-pairmatching-precourse\\src\\main\\resources\\frontend-crew.md");
            FileReader filereader = new FileReader(frontend);
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            while ((line = bufReader.readLine()) != null) {
                frontendCrewNames.add(line);
            }
            bufReader.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void findIndex(String[] courses) {
        findIndexLevel1(courses);
        findIndexLevel2(courses);
        findIndexLevel4(courses);
    }

    private void findIndexLevel1(String[] courses) {
        if (courses[1].equals("레벨1") && courses[2].equals("자동차경주")) {
            courseIndex = LEVEL1_CarRACING;
        }
        if (courses[1].equals("레벨1") && courses[2].equals("로또")) {
            courseIndex = LEVEL1_LOTTO;
        }
        if (courses[1].equals("레벨1") && courses[2].equals("숫자야구게임")) {
            courseIndex = LEVEL1_BASEBALL;
        }
    }

    private void findIndexLevel2(String[] courses) {
        if (courses[1].equals("레벨2") && courses[2].equals("장바구니")) {
            courseIndex = LEVEL2_BASKET;
        }
        if (courses[1].equals("레벨2") && courses[2].equals("결제")) {
            courseIndex = LEVEL2_PAYMENT;
        }
        if (courses[1].equals("레벨2") && courses[2].equals("지하철노선도")) {
            courseIndex = LEVEL2_SUBWAY;
        }
    }

    private void findIndexLevel4(String[] courses) {
        if (courses[1].equals("레벨4") && courses[2].equals("성능개선")) {
            courseIndex = LEVEL4_PERFORMANCE;
        }
        if (courses[1].equals("레벨2") && courses[2].equals("배포")) {
            courseIndex = LEVEL4_STREAM;
        }
    }

    public boolean checkAlready(String[] courses) {
        if (courses[0].equals("백엔드")) {
            if (pairsBackend.get(courseIndex).size() != 0) {
                return true;
            }
        }
        if (courses[0].equals("프론트엔드")) {
            if (pairsFrontend.get(courseIndex).size() != 0) {
                return true;
            }
        }
        return false;
    }

    public void matching(String[] courses) {
        if (courses[0].equals("백엔드")) {
            matchingBackend();
            return;
        }
        if (courses[0].equals("프론트엔드")) {
            matchingFrontend();
        }

    }

    private void matchingBackend() {
        int check = 0;
        while (check < 3) {
            backendCrewNames = Randoms.shuffle(backendCrewNames);
            pairsBackend.set(courseIndex, new ArrayList<> (backendCrewNames));
            break;
        }
        result(0);

    }

    private void matchingFrontend() {
        int check = 0;
        while (check < 3) {
            frontendCrewNames = Randoms.shuffle(frontendCrewNames);
            pairsFrontend.set(courseIndex, new ArrayList<> (frontendCrewNames));
            break;
        }
        result(1);
    }

    private boolean checkBackendCrews() {
        if (courseIndex <= LEVEL1_BASEBALL) {
            if (courseIndex != LEVEL1_CarRACING) {
                for (int i = 0; i < backendCrewNames.size(); i++) {
                    int temp = pairsBackend.get(courseIndex).indexOf(backendCrewNames.get(i));
                    if (temp % 2 == 0) {

                    }
                }
            }
        }
        return false;
    }

    private void result(int type) {
        createInfo(type);
        System.out.println(Message.RESULT_PAIR);
        for (int i = 0; i < temp.size() - 2; i = i + 2) {
            System.out.println(temp.get(i) + " : " + temp.get(i+1));
        }
        System.out.print(temp.get(temp.size()- 2) + " : " + temp.get(temp.size()- 1));
        if (temp.size() % 2 == 0) {
            System.out.println(" : " + temp.get(temp.size() - 1));
            return;
        }
        System.out.println();
    }

    private void createInfo(int type) {
        if (type == 0) {
            temp = pairsBackend.get(courseIndex);
            return;
        }
        if (type == 1) {
            temp = pairsFrontend.get(courseIndex);
            return;
        }
    }

}

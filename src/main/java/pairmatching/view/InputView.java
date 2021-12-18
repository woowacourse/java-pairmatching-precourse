package pairmatching.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private InputView() {
    }

    public static List<String> inputBackEndCrews() {
        try {
            File file = new File("src/main/resources/backend-crew.md");
            Scanner scanner = new Scanner(file);
            List<String> crews = new ArrayList<>();
            while(scanner.hasNextLine()) {
                crews.add(scanner.nextLine());
            }
            return crews;
        } catch (FileNotFoundException e) {
            System.out.println("파일 입력이 에러가 발생했습니다.");
            throw new RuntimeException(e.getMessage());
        }
    }

    public static List<String> inputFrondEndCrews() {
        try {
            File file = new File("src/main/resources/backend-crew.md");
            Scanner scanner = new Scanner(file);
            List<String> crews = new ArrayList<>();
            while(scanner.hasNextLine()) {
                crews.add(scanner.nextLine());
            }
            return crews;
        } catch (FileNotFoundException e) {
            System.out.println("파일 입력이 에러가 발생했습니다.");
            throw new RuntimeException(e.getMessage());
        }
    }

    public static List<String> inputFirstLevelMission() {
        try {
            File file = new File("src/main/resources/level-one.md");
            Scanner scanner = new Scanner(file);
            List<String> missionNames = new ArrayList<>();
            while(scanner.hasNextLine()) {
                missionNames.add(scanner.nextLine());
            }
            return missionNames;
        } catch (FileNotFoundException e) {
            System.out.println("파일 입력이 에러가 발생했습니다.");
            throw new RuntimeException(e.getMessage());
        }
    }

    public static List<String> inputSecondLevelMission() {
        try {
            File file = new File("src/main/resources/level-two.md");
            Scanner scanner = new Scanner(file);
            List<String> missionNames = new ArrayList<>();
            while(scanner.hasNextLine()) {
                missionNames.add(scanner.nextLine());
            }
            return missionNames;
        } catch (FileNotFoundException e) {
            System.out.println("파일 입력이 에러가 발생했습니다.");
            throw new RuntimeException(e.getMessage());
        }
    }

    public static List<String> inputThirdLevelMission() {
        try {
            File file = new File("src/main/resources/level-three.md");
            Scanner scanner = new Scanner(file);
            List<String> missionNames = new ArrayList<>();
            while(scanner.hasNextLine()) {
                missionNames.add(scanner.nextLine());
            }
            return missionNames;
        } catch (FileNotFoundException e) {
            System.out.println("파일 입력이 에러가 발생했습니다.");
            throw new RuntimeException(e.getMessage());
        }
    }

    public static List<String> inputFourthLevelMission() {
        try {
            File file = new File("src/main/resources/level-four.md");
            Scanner scanner = new Scanner(file);
            List<String> missionNames = new ArrayList<>();
            while(scanner.hasNextLine()) {
                missionNames.add(scanner.nextLine());
            }
            return missionNames;
        } catch (FileNotFoundException e) {
            System.out.println("파일 입력이 에러가 발생했습니다.");
            throw new RuntimeException(e.getMessage());
        }
    }

    public static List<String> inputFifthLevelMission() {
        try {
            File file = new File("src/main/resources/level-five.md");
            Scanner scanner = new Scanner(file);
            List<String> missionNames = new ArrayList<>();
            while(scanner.hasNextLine()) {
                missionNames.add(scanner.nextLine());
            }
            return missionNames;
        } catch (FileNotFoundException e) {
            System.out.println("파일 입력이 에러가 발생했습니다.");
            throw new RuntimeException(e.getMessage());
        }
    }
}

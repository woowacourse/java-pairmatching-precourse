package pairmatching;

import pairmatching.Controller.Controller;


public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        Controller controller = new Controller();
        controller.start();
        /*
        String names = "백호 태웅 치수 태섭 대만 준호 대협 덕규 태산 경태 수겸 현준 준섭 한나 소연 호열 대남 용팔 구식 달재";
        List<String> crewNames = new ArrayList<String>(); // 파일에서 로드한 크루 이름 목록

        String[] splitNames = names.split(" ");
        for(int i = 0; i < splitNames.length; i++) {
            crewNames.add(splitNames[i]);
        }
        System.out.println(crewNames);

        List<String> shuffledCrew = Randoms.shuffle(crewNames); // 섞인 크루 이름 목록
        System.out.println(shuffledCrew);

        // 백호 태웅 치수 태섭 대만 준호 대협 덕규 태산 경태 수겸 현준 준섭 한나 소연 호열 대남 용팔 구식 달재
        */
    }
}
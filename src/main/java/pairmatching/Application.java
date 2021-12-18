package pairmatching;

import pairmatching.service.CrewService;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
		CrewService crewService = new CrewService();
		System.out.println(crewService.getBackendCrew());
		System.out.println(crewService.getFrontendCrew());
    }
}

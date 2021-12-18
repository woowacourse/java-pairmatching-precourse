package pairmatching.status;

import pairmatching.crew.MissionRepository;

public class PairMatchingInitializer implements PairMatchingApplicationStatus {
    @Override
    public void execute() {
        System.out.println("초기화 되었습니다.");
        MissionRepository.clear();
    }
}

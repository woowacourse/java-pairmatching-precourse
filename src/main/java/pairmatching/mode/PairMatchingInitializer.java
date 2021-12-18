package pairmatching.mode;

import pairmatching.MissionRepository;

public class PairMatchingInitializer implements PairMatchingService {

    @Override
    public void run() {
        System.out.println("초기화 되었습니다.");
        MissionRepository.clear();
    }
}

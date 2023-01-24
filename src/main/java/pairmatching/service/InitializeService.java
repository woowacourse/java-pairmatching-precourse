package pairmatching.service;

import pairmatching.repository.MatchInfoRepository;

public class InitializeService {
    public static final MatchInfoRepository matchInfoRepository = MatchInfoRepository.getInstance();

    public void matchInfo() {
        matchInfoRepository.initMatchInfo();
    }
}
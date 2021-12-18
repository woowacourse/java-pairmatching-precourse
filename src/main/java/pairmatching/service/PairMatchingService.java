package pairmatching.service;

import java.io.IOException;
import java.util.ArrayList;

import pairmatching.domain.Crew;
import pairmatching.util.Initializer;

public class PairMatchingService {
    ArrayList<Crew> backEndCrews;
    ArrayList<Crew> frontEndCrews;

    public PairMatchingService() {
        registerCrews();
    }

    private void registerCrews(){
        try {
            backEndCrews = Initializer.registerBackEndCrews();
            frontEndCrews = Initializer.registerFrontEndCrews();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}

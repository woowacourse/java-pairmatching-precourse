package pairmatching;

import pairmatching.controller.PairController;
import pairmatching.domains.crew.BackendCrews;
import pairmatching.domains.crew.FrontendCrews;
import pairmatching.domains.mission.Missions;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        new PairController(new FrontendCrews(), new BackendCrews(), new Missions()).initiate();

    }
}

package pairmatching.controller;

import pairmatching.domain.Crews;

public class PairMatcher implements Controller {
    private final Crews crews;

    public PairMatcher(Crews crews) {
        this.crews = crews;
    }

    @Override
    public void execute() {
    }
}

package pairmatching.controller;

import pairmatching.domain.Crews;

public class PairsViewer implements Controller {

    private final Crews crews;

    public PairsViewer(Crews crews) {
        this.crews = crews;
    }

    @Override
    public void execute() {
    }

}

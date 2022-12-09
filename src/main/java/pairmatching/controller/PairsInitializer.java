package pairmatching.controller;

import pairmatching.domain.Crews;

public class PairsInitializer implements Controller {

    private final Crews crews;

    public PairsInitializer(Crews crews) {
        this.crews = crews;
    }

    @Override
    public void execute() {
    }
}

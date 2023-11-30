package pairmatching.controller;

import pairmatching.service.PeopleService;

public class PairMatchingController {
    private final PeopleService peopleService;

    public PairMatchingController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    public void run(){
        InputPeople();
    }

    private void InputPeople(){
        peopleService.initPeople();
    }
}

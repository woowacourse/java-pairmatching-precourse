package pairmatching.controller;

import java.util.ArrayList;
import java.util.List;

import pairmatching.model.domain.History;
import pairmatching.model.MatchGenerator;
import pairmatching.model.MatchMachine;
import pairmatching.model.domain.Menu;
import pairmatching.model.domain.Options;
import pairmatching.view.Input;
import pairmatching.view.Output;

public class PairMachineController {

    public void run() {
        List<History> pairHistory = new ArrayList<>();
        MatchMachine machine = new MatchMachine(new MatchGenerator(), pairHistory);

        start(machine, pairHistory);
    }

    private void start(MatchMachine machine, List<History> pairHistory) {
        while (true) {
            Menu menu = Input.menu();
            if (menu == Menu.STOP) {
                break;
            }
            if (menu == Menu.PAIR_MATCHING) {
                createPairs(machine, pairHistory);
            }
        }
    }

    private void createPairs(MatchMachine machine, List<History> pairHistory) {
        Options options = Input.options();
        History history = machine.createPair(options);
        pairHistory.add(history);
        Output.pairPrint(history.getPairs());
    }
}

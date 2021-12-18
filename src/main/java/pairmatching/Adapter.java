package pairmatching;

import pairmatching.mapper.IndexMapper;
import pairmatching.view.InputView;

public class Adapter {
    public void run() {
        while (true) {
            String request = InputView.printIndex();
            IndexMapper.map(request);
        }
    }
}

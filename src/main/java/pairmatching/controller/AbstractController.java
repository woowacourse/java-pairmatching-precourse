package pairmatching.controller;

import pairmatching.outputview.ErrorMessageOutputView;
import pairmatching.outputview.OutputView;

import java.util.Map;

public abstract class AbstractController implements Controller {
    private final OutputView outputView = new ErrorMessageOutputView();

    @Override
    public void process(Map<String, Object> model) {
        try {
            doProcess(model);
        } catch (IllegalArgumentException e) {
            model.put("errorMessage", e.getMessage());
            outputView.print(model);

            doProcess(model);
        }
    }

    abstract void doProcess(Map<String, Object> model);
}

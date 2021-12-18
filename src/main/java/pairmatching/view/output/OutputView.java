package pairmatching.view.output;

import pairmatching.model.crew.CrewPair;

import java.util.List;

public interface OutputView {
    void showMatchedCrews(final List<CrewPair> matchedCrews);
}

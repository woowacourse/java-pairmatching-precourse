package pairmatching.view;

import pairmatching.PairMatchingController;
import pairmatching.domain.PairCrews;
import pairmatching.dto.PairDto;

public class PairMatchingView extends CommonView {
	public PairMatchingView(PairMatchingController pairMatchingController) {
		super(pairMatchingController);
	}

	@Override
	public void show() {
		String pairInformation = inputProcessor.readPairInformation();
		PairCrews pairCrews = pairMatchingController.matchCrews(new PairDto(pairInformation));
		outputProcessor.printPairCrews(pairCrews);
	}
}

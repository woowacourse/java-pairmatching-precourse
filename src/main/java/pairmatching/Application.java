package pairmatching;

import pairmatching.controller.PairMathcerController;
import pairmatching.domain.crew.Crews;
import pairmatching.domain.input.Course;

public class Application {
	public static void main(String[] args) {
		Crews frontEndCrews = Crews.of("src/main/resources/frontend-crew.md", Course.FRONTEND);
		Crews backEndCrews = Crews.of("src/main/resources/backend-crew.md", Course.BACKEND);

		PairMathcerController pairMathcerController = new PairMathcerController();
		pairMathcerController.init();
	}

}

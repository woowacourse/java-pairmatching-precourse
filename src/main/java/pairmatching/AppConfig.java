package pairmatching;

import pairmatching.controller.MatchingController;
import pairmatching.controller.MatchingControllerImpl;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.CrewRepositoryImpl;
import pairmatching.repository.MatchGroupRepository;
import pairmatching.service.MatchingService;
import pairmatching.service.MatchingServiceImpl;
import pairmatching.view.input.InputView;
import pairmatching.view.output.OutputView;

public class AppConfig {

	private static final AppConfig instance = new AppConfig();

	public final MatchingController matchingController;
	public final MatchingService matchingService;
	public final CrewRepository crewRepository;
	public final MatchGroupRepository matchGroupRepository;
	public final OutputView outputView;
	public final InputView inputView;

	private AppConfig() {
		this.outputView = new OutputView();
		this.inputView = new InputView();
		this.matchGroupRepository = new MatchGroupRepository();
		this.crewRepository = new CrewRepositoryImpl();
		this.matchingService = new MatchingServiceImpl(matchGroupRepository, crewRepository);
		this.matchingController = new MatchingControllerImpl(matchingService, inputView, outputView);
	}

	public static AppConfig getInstance() {
		return instance;
	}

}

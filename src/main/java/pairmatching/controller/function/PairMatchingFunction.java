package pairmatching.controller.function;

import static pairmatching.view.InputView.*;
import static pairmatching.view.OutputView.*;

import java.util.Arrays;

import pairmatching.domain.PairMatching;
import pairmatching.domain.repository.PairMatchingRepository;
import pairmatching.service.PairMatchingService;

public enum PairMatchingFunction {
	PAIR_MATCHING("1") {
		@Override
		void function() {
			printPairMatchingScreen();
			String[] splitPairMatching = inputPairMatching().split(",");
			String course = splitPairMatching[0].trim();
			String level = splitPairMatching[1].trim();
			String mission = splitPairMatching[2].trim();
			if (PairMatchingRepository.isExistPairMatching(course, level, mission)) {
				if (inputRequestRematching().equals("네")) {
					PairMatchingService.pairReMatching(course, level, mission);
				}
			}
			PairMatchingService.pairMatching(course, level, mission);
		}
	},
	PAIR_FIND("2") {
		@Override
		void function() {
			printPairMatchingScreen();
			String[] splitPairMatching = inputPairMatching().split(",");
			String course = splitPairMatching[0].trim();
			String level = splitPairMatching[1].trim();
			String mission = splitPairMatching[2].trim();
			PairMatching pairMatching = PairMatchingRepository.find(course, level, mission);
			printPairMatchingResult(pairMatching.getPairMatchingResult());
		}
	},
	PAIR_RESET("3") {
		@Override
		void function() {
			PairMatchingRepository.reset();
		}
	},
	QUIT("Q") {
		@Override
		void function() {

		}
	};

	private String command;

	abstract void function();

	PairMatchingFunction(String command) {
		this.command = command;
	}

	public String getCommand() {
		return command;
	}

	public static PairMatchingFunction findFunction(String command) {
		return Arrays.stream(values())
			.filter(function -> function.command.equals(command))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("올바르지 않은 명령어 입니다."));
	}

	public void apply() {
		function();
	}

	public boolean isQuit() {
		return this == QUIT;
	}
}

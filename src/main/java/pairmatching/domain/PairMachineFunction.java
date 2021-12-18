package pairmatching.domain;

import java.util.Arrays;

public enum PairMachineFunction {
	PAIR_MATCHING("1"){
		@Override
		void function() {

		}
	},
	PAIR_FIND("2"){
		@Override
		void function() {

		}
	},
	PAIR_INITIAL("3"){
		@Override
		void function() {

		}
	},
	QUIT("Q"){
		@Override
		void function() {

		}
	};

	private String command;
	abstract void function();

	PairMachineFunction(String command) {
		this.command = command;
	}

	public String getCommand() {
		return command;
	}

	public static PairMachineFunction findFunction(String command){
		return Arrays.stream(values())
			.filter(function -> function.command.equals(command))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("올바르지 않은 명령어 입니다."));
	}

	public void apply() {
		function();
	}
}

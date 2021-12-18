package pairmatching.domain;

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
	}
	;

	private String command;
	abstract void function();

	PairMachineFunction(String command) {
		this.command = command;
	}
}

package pairmatching.model;

import java.util.Arrays;

import pairmatching.controller.PairMatchingController;
import pairmatching.validator.LevelValidator;
import pairmatching.validator.RoleValidator;

public enum Role {
	PAIR_MATCH("1", "페어 매칭") {
		public void role() {
			PairMatchingController.match();
		}
	},
	PAIR_INQUIRE("2", "페어 조회") {
		public void role() {
			PairMatchingController.inquire();
		}
	},
	PAIR_INITIALIZE("3", "페어 초기화") {
		public void role() {
			PairMatchingController.initialize();
		}
	},
	EXIT("Q", "종료") {
		public void role() {

		}
	};

	private String number;
	private String name;

	Role(String number, String name) {
		this.number = number;
		this.name = name;
	}

	public String getNumber() {
		return this.number;
	}

	public String toString() {
		return number + ". " + name;
	}

	public static Role parse(String number) {
		return Arrays.stream(values())
			.filter(role -> number.equals(role.number))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(RoleValidator.ERROR_NOT_EXISTED));
	}

	public abstract void role();

}

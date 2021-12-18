package pairmatching.model.enums;

import static pairmatching.constant.SystemMessage.*;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Process {
	BACK_END("백엔드"),
	FRONT_END("프론트엔드");

	private String process;

	Process(String process) {
		this.process = process;
	}

	public String getProcess() {
		return process;
	}

	public static String getProcessMessage() {
		return String.join(DELIMITER,
			Arrays.stream(Process.values())
				.map(Process::getProcess)
				.collect(Collectors.toList()));
	}
}

package pairmatching.dto;

import pairmatching.domain.Pairs;

public class ResponsePairsDto {
	private Pairs pairs;

	public ResponsePairsDto(Pairs pairs) {
		this.pairs = pairs;
	}

	public Pairs getPairs() {
		return pairs;
	}
}

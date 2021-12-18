package pairmatching.controller;

import java.util.List;

import pairmatching.model.Crew;

public class PairMaker {
	public PairMaker() {

	}

	public void make(List<Crew> crews) {
		for (Crew c: crews) {
			System.out.println(c.getName());
		}
	}
}

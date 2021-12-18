package pairmatching;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import pairmatching.domain.Crews;

public class Application {
	public static void main(String[] args) {
		MatchingMachine matching = new MatchingMachine();
		matching.run();
	}


}

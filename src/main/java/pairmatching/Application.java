package pairmatching;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import pairmatching.controller.PairMatchingController;

public class Application {
	public static void main(String[] args) {
		PairMatchingController pairMatchingController = new PairMatchingController();
		pairMatchingController.run();

	}
}

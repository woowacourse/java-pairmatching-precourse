package pairmatching;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pairmatching.controller.InputController;
import pairmatching.controller.PairMatchingController;

import pairmatching.models.Pair;

import pairmatching.utils.DataValidation;
import pairmatching.utils.NameList;

import pairmatching.view.PairMachineInput;
import pairmatching.view.PairMachiningOutput;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
		final NameList nameList = new NameList();
		final PairMachiningOutput output = new PairMachiningOutput();
		final List<Pair> pairs = new ArrayList<>();
		final InputController input = new InputController(new PairMachineInput(), new DataValidation());
		PairMatchingController controller = new PairMatchingController(nameList, output, pairs, input);
		try {
			controller.startProgram();
		} catch (IOException error) {
			System.out.println(error);
		}
    }
}

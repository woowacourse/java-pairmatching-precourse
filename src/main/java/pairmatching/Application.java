package pairmatching;

import pairmatching.maching.MachingController;
import pairmatching.maching.MachingService;

public class Application {
	public static void main(String[] args) {
		MachingController machingController = new MachingController();

		MachingService machingService = new MachingService();
		// machingService.makeMaching(Course.BACKEND, Level.LEVEL1, "자동차경주");
		// Maching maching = machingList().get(0);
		// System.out.println(maching.getPairList().size());
		// List<Pair> pairList = maching.getPairList();
		// pairList.get(0).getCrews().stream().forEach(p -> System.out.println(p.getName()));

		machingController.run();

	}
}

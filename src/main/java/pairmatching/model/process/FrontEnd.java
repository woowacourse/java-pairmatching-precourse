package pairmatching.model.process;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class FrontEnd implements ProcessCrew {
	private List<String> crew = new ArrayList<>();

	public FrontEnd() {
		try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/frontend-crew.md"))) {
			while (true) {
				String member = br.readLine();
				if (member == null)
					break;
				crew.add(member);
			}
		} catch (IOException exception) {
			System.out.println(exception.getMessage());
		}
	}

	@Override
	public List<String> getShuffledCrew() {
		return Randoms.shuffle(crew);
	}
}

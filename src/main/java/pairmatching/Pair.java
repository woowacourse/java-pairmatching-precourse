package pairmatching;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pair {
	private final List<Crew> crews;

	public Pair(List<Crew> crews) {
		this.crews = new ArrayList<>();
		this.crews.addAll(crews);
	}

	public List<Crew> get() {
		return crews;
	}

	public boolean contains(Crew crew) {
		return crews.contains(crew);
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Pair)) {
			return false;
		}
		Pair counterPart = (Pair)object;
		List<Crew> result = crews.stream().filter(counterPart::contains).collect(Collectors.toList());
		if (result.size() == 0) {
			return true;
		}
		return false;
	}
}

package pairmatching;

public class Application {
	public static void main(String[] args) {
		Crews frontEndCrews = Crews.of("src/main/resources/frontend-crew.md", Course.FRONTEND);
		Crews backEndCrews = Crews.of("src/main/resources/backend-crew.md", Course.BACKEND);
	}

}

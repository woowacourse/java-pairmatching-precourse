package pairmatching.client;

public class ConsoleErrorClient implements ErrorClient {

	@Override
	public void error(String message) {
		System.out.println(message);
	}
}

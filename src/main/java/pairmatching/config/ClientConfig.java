package pairmatching.config;

import pairmatching.client.ConsoleErrorClient;
import pairmatching.client.ConsoleInputClient;
import pairmatching.client.ConsoleOutputClient;
import pairmatching.client.ErrorClient;
import pairmatching.client.InputClient;
import pairmatching.client.OutputClient;

public class ClientConfig {
	public static ErrorClient getErrorClient() {
		return new ConsoleErrorClient();
	}

	public static OutputClient getOutputClient() {
		return new ConsoleOutputClient();
	}

	public static InputClient getInputClient() {
		return new ConsoleInputClient(getOutputClient());
	}
}

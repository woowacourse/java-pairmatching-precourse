package pairmatching.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.function.Consumer;
import java.util.function.Supplier;

public final class InputUtil {

    private InputUtil() {

    }

    public static String input() {
        return Console.readLine();
    }

    public static <T> T retryOnInvalidInput(Supplier<T> inputSupplier,
                                            Consumer<String> errorHandler) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (IllegalArgumentException e) {
                errorHandler.accept(e.getMessage());
            }
        }
    }
}

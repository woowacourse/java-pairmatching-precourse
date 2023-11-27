package util;

import camp.nextstep.edu.missionutils.Console;
import java.util.function.Supplier;

public final class InputUtil {

    public static String input() {
        return Console.readLine();
    }

    public static <T> T retryOnInvalidInput(Supplier<T> inputSupplier, String errorMessage) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(errorMessage);
            }
        }
    }
}

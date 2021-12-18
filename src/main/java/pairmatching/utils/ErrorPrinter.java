package pairmatching.utils;

public class ErrorPrinter {

    private static final String ERR_PREFIX = "[ERROR]";

    public static void print(Throwable e) {
        System.out.println(String.join(ERR_PREFIX, e.getMessage()));
    }
}


package pairmatching.view.ouput;

class OutputWriter {

    OutputWriter() {
    }

    public static void println(Object object) {
        System.out.println(object);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printMessageResponse(OutputMessage responseMessage) {
        println(responseMessage.getMessage());
    }
}

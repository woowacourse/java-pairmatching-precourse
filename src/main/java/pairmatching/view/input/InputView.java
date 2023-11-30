package pairmatching.view.input;

public class InputView {
    public static Map<String, Product> createVMProductFromInput() {
        String products = InputUtil.readLine();
        return  Parser.parseVMProductsInput(products);
    }
}

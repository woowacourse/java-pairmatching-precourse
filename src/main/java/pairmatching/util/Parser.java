package pairmatching.util;

import static pairmatching.exception.ErrorCode.INVALID_INPUT;

import java.util.regex.Matcher;

public class Parser {
    private static final String DELIMITER = ";";
    private static final int POSITIVE_NUMBER_MINIMUM_RANGE = 1;
    // 10원부터 시작하며, 10원으로 나누어떨어지
    private static final Pattern REGEX_COIN_PATTERN = Pattern.compile("^(10|\\d{1,})0$");
    private static final Pattern REGEX_PRODUCT_PATTERN = Pattern.compile(
            "\\[([^,]+),(\\d+),(\\d+)]");
    // 100원부터 시작하며, 10원으로 나누어떨어지는 정규식
    private static final Pattern REGEX_PRICE_PATTERN = Pattern.compile("^(100|\\d{2,})(0)$");
    private static final Pattern REGEX_MENU_PATTERN = Pattern.compile("^.+$");
    private static Map<String, Product> productMap = new HashMap<>();

    // Default Constructor
    private Parser() {
    }

    //== Business Logic ==//
    public static int parseMoneyInput(String coinInput) {
        INVALID_COIN_INPUT.validate(() -> hasWhitespace(coinInput));
        INVALID_INPUT.validate(() -> isInvalidCoinPattern(coinInput));
        return ExceptionHandler.tryOnParseException(() -> Integer.parseInt(coinInput));
    }

    public static Map<String, Product> parseVMProductsInput(String productsInput) {
        String[] products = productInputValidation(productsInput);
        return parsingInput(products);
    }

    private static Map<String, Product> parsingInput(String[] products) {
        Map<String, Product> resultProductMap = new HashMap<>();
        for (String product : products) {
            Matcher matcher = productFormatValidation(product);
            if (!matcher.matches()) {
                INVALID_PRODUCT_FORMAT.validate(() -> true); // Invalid product format
            }
            ExceptionHandler.tryOnParseException(() -> parseProducts(matcher));
            resultProductMap.putAll(productMap);
        }
        return resultProductMap;
    }


    private static Map<String, Product> parseProducts(Matcher matcher) {
        do {
            String productName = productProductNameValidation(matcher.group(1));
            int price = productProductPriceValidation(matcher.group(2));
            int quantity = productProductQuantityValidation(matcher.group(3));

            Product product = new Product(productName, price, quantity);
            productMap.put(productName, product);
        } while (matcher.find());

        return productMap;
    }


    private static String[] productInputValidation(String productsInput) {
        INVALID_PRODUCT_FORMAT.validate(() -> hasWhitespace(productsInput));
        INVALID_PRODUCT_FORMAT.validate(()->isEndWithDelimiter(productsInput));
        return productsInput.split(DELIMITER);
    }

    private static Matcher productFormatValidation(String productsInput) {
        INVALID_PRODUCT_FORMAT.validate(() -> hasWhitespace(productsInput));
        return REGEX_PRODUCT_PATTERN.matcher(productsInput);
    }


    private static String productProductNameValidation(String nameInput) {
        INVALID_PRODUCT_NAME.validate(() -> hasWhitespace(nameInput));
        return nameInput;
    }

    private static int productProductPriceValidation(String priceInput) {
        INVALID_PRODUCT_PRICE.validate(() -> hasWhitespace(priceInput));
        INVALID_PRODUCT_PRICE.validate(() -> isInvalidPricePattern(priceInput));
        return ExceptionHandler.tryOnParseException(() -> Integer.parseInt(priceInput));
    }

    private static int productProductQuantityValidation(String quantityInput) {
        INVALID_PRODUCT_QUANTITY.validate(() -> hasWhitespace(quantityInput));
        int price = ExceptionHandler.tryOnParseException(() -> Integer.parseInt(quantityInput));
        INVALID_PRODUCT_NAME.validate(() -> isNotPositiveInteger(price));
        return price;
    }

    //== Validation Method ==//
    // 빈칸을 가지고 있는가
    private static boolean hasWhitespace(String input) {
        return input.chars().anyMatch(Character::isWhitespace);
    }

    // 패턴에 맞는가
    private static boolean isInvalidPricePattern(String input) {
        return matchWithRegex(input, REGEX_PRICE_PATTERN);
    }

    // 끝이 DELIMITER로 끝나는가
    private static boolean isEndWithDelimiter (String input) {
        return input.endsWith(DELIMITER);
    }

    // 양수인가
    private static boolean isNotPositiveInteger(Integer value) {
        return value < POSITIVE_NUMBER_MINIMUM_RANGE;
    }

    // == 정규표현식 제약 조건== //
    private static boolean matchWithRegex(String input, Pattern regex) {
        Matcher matcher = regex.matcher(input);
        return !matcher.matches();
    }
}

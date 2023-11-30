package pairmatching.view.ouput;

public final class OutputView extends OutputWriter {

    public static void printPurchaserMoney(int money){
        System.out.printf(RESPONSE_USER_COIN.getFormat(), money);
    }
}
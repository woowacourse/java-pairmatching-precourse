package pairmatching.utils;

public class Converter {
	public static int getInt(String numberString) {
		return Integer.parseInt(numberString);
	}

	public static String getString(int number) {
		return Integer.toString(number);
	}

	// spilt 코드
	// public static ArrayList<Beverage> getBeverages(String beverageString) {
	// 	ArrayList<Beverage> beverages = new ArrayList<>();
	// 	for (String beverage : beverageString.split(Constants.SEPARATOR)) {
	// 		beverages.add(new Beverage(
	// 			beverage
	// 				.substring(1, beverage.length() - 1)
	// 				.split(Constants.DELIMITER)));
	// 	}
	// 	return beverages;
	// }
}

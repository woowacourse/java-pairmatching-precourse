package pairmatching.utils;

import static pairmatching.constant.constant.*;

public class Splitter {

	public static String[] SplitByComma(String source){
		return source.replaceAll(BLANK, "").split(COMMA);
	}
}

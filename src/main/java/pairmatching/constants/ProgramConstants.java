package pairmatching.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ProgramConstants {
	public static final String FUNCTION1 = "페어 매칭";
	public static final String FUNCTION2 = "페어 조회";
	public static final String FUNCTION3 = "페어 초기화";
	public static final String QUIT = "종료";
	public static final List<String> FUNCTION_OPTIONS = new ArrayList<>(Arrays.asList("1", "2", "3", "Q"));
	public static Map<String, List<String>> MISSION_MAP = new LinkedHashMap<String, List<String>>() {
		{
			put("레벨1", Arrays.asList("자동차경주", "로또", "숫자야구게임"));
			put("레벨2", Arrays.asList("장바구니 ", "결제", "지하철노선도"));
			put("레벨3", Collections.emptyList());
			put("레벨4", Arrays.asList("성능개선", "배포"));
			put("레벨5", Collections.emptyList());
		}
	};
	public static final String PAIR_MACH_SELECT = FUNCTION_OPTIONS.get(0);
	public static final String PAIR_CHECK_SELECT = FUNCTION_OPTIONS.get(1);
	public static final String RESET_SELECT = FUNCTION_OPTIONS.get(2);
	public static final String QUIT_SELECT = FUNCTION_OPTIONS.get(3);

}

package pairmatching.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public enum Level {

	LEVEL_1("레벨1", Arrays.asList("자동차경주", "로또", "숫자야구게임")),
	LEVEL_2("레벨2", Arrays.asList("장바구니", "결제", "지하철노선도")),
	LEVEL_3("레벨3", Collections.emptyList()),
	LEVEL_4("레벨4", Arrays.asList("성능개선", "배포")),
	LEVEL_5("레벨5", Collections.emptyList());

	private final String level; // 문자열 그룹명
	private final List<String> missions; // 문자열리스트의 list명칭

	Level(String level, List<String> missions) {
		this.level = level;
		this.missions = missions;
	}

	public static String findLevelByMission(String element) { // <- 문자열리스트 중 1개 원소 변수명
		return Arrays.stream(Level.values())
			// .filter(enumVariable -> enumVariable..stream()
			// 	.anyMatch(elementInStringList -> elementInStringList.equals(element)))
			.filter(hasElementInGroup(element))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("포함되는 문자열 리스트 그룹이 없습니다."))
			.getLevel();
	}

	public String getLevel() {
		return this.level;
	}

	private static Predicate<Level> hasElementInGroup(String element) {
		return e -> e.missions.stream()
			.anyMatch(elementInStringList -> elementInStringList.equals(element));
	}

	// 추가1) Enum내부에서 this. 스태틱처럼 쓰이는  [외부에서쓰는 Enum.특정 상수객체]를 의미한다.
	// -> Enum의 인스턴스메서드로  boolean을 정의해두면,  ENum list -> stream -> filter(), anyMatch() Enum::isXXXX ?  Enum::isContains ?? 형태로 필터링이 가능해진다?
	// 1) [매핑변수가 없]을 땐   boolean  [나올 결과 Enum상수객체가] .is특정상수객체 ? 를  return 분기별 this(ENum.특정상수객체) == 들어온 [[특정상수객체]]
	//    [매핑변수가 문자열]일 땐   boolean  is특정상수객체( [문자열] ) ? 를  return this(ENum.특정상수객체).[[매핑문자열변수]].equals(들어온[[문자열]])
	// 2) [매핑변수가 list]일 땐   public boolean  [특정상수객체].isContains( [원소1개] ) ? 를  return this(ENum.특정상수객체)[[.매핑list변수]].contains( 들어온[[ list 원소]])
	// -> 사용을 List<Enum> -> stream -> ( Enum :: is특정상수객체? ) 로, 해당 Enum객체만 골라 모을 수 있다.

	// static 메서드가 아니라면, 특정상수객체. 확인용이다.
	// -> list는, 검색용 파라미터 원소1개가 들어오고, 어느그룹인지 -> 인스턴스메서드로서, 해당 그룹의 상수객체.로 직접 호출한다.
	// -> ex> Enum.특정상수객체(그룹). isContains ( 검색용 원소 )
	public boolean isContains(String elementInStringList) {
		return this.missions.contains(elementInStringList);
	}

	//** public 인스턴스: 검색대상 그룹 사용자가 객체로 지정 / public static:  검색대상그룹도 finder로 찾도록 해야함.**

	// 추가2) 특정상수객체의 인스턴스메서드가 아니라, static메서드로 선언한다면
	// -> 검색대상이 되는 그룹(상수객체)를,  매핑문자열(그룹명) -> finder로 찾아서 검색한다
	public static boolean isContains(String group, String name) {
		// 1) 먼저 검색대상 그룹을 finder로 찾는다.
		return Arrays.stream(Level.values())
			.filter(enumVariable -> enumVariable.level.equals(group))
			.findAny()
			.orElseThrow(NoSuchElementException::new)
			// 2) 대상그룹 (Enum상수객체) 를 찾았으면, contains로 확인하단.
			.missions.contains(name);
	}

}


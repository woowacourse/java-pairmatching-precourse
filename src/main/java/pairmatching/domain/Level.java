package pairmatching.domain;

import pairmatching.domain.Mission;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public enum Level {
	  LEVEL1("레벨1", Arrays.asList(Mission.GAME_RACINGCAR, Mission.GAME_LOTTO, Mission.GAME_BASEBALL)),
	  LEVEL2("레벨2", Arrays.asList(Mission.SHOPPINGBAG, Mission.PAY, Mission.SUBWAY_LINEMAP)),
	  LEVEL3("레벨3", Arrays.asList(Mission.EMPTY)),
	  LEVEL4("레벨4", Arrays.asList(Mission.IMPROVEMENT, Mission.DISTRIBUTION)),
	  LEVEL5("레벨5", Arrays.asList(Mission.EMPTY));

	  private String name;
	  private List<Mission> missionList;

	  Level(String name, List<Mission> missionList) {
	    this.name = name;
	    this.missionList= missionList;
	  }
	  
	  public String getLevel() {
		  return name;
	  }

	  public Level findByMissionType(Mission missionName) {
		  Optional<Level> level = Arrays.stream(Level.values())
				  .filter(mission -> mission.hasMissionCode(missionName))
				  .findAny();
		  if(!level.isPresent()) throw new IllegalArgumentException();
		  return level.get();
	  }
	  
	  public boolean hasMissionCode(Mission missionName) {
		  return missionList.stream().anyMatch(mission -> mission.equals(missionName));
	  }
	  
	  public static boolean hasLevel(String value) {
		  return Stream.of(Level.values())
				  .filter(level -> level.equals(value))
				  .findFirst()
				  .isPresent();
	  }
}

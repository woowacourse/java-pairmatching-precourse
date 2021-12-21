package pairmatching;

import java.util.ArrayList;

import org.assertj.core.util.Arrays;

public enum Level {
	  LEVEL1("레벨1"),
	  LEVEL2("레벨2"),
	  LEVEL3("레벨3"),
	  LEVEL4("레벨4"),
	  LEVEL5("레벨5");

	  private String name;

	  Level(String name) {
	    this.name = name;
	  }
	  public String getLevel() {
		return name;
		  
	  }
	  public ArrayList<String> getMission() {
		  ArrayList<String> missionList= new ArrayList<>(); 
		  if(this.name ==LEVEL1.getLevel()) {
			  missionList.add("자동차경주");
			  missionList.add("로또");
			  missionList.add("숫자야구게임");
			  return missionList;
		  }
		  if(this.name == LEVEL2.getLevel()) {
			  missionList.add("장바구니");
			  missionList.add("결제");
			  missionList.add("지하철노선도");
			  return missionList;
		  }
		  if(this.name.equals(LEVEL3.getLevel())) {
			  return missionList;
		  }
		  if(name.equals(LEVEL4.getLevel())) {
			  missionList.add("성능개선");
			  missionList.add("배포");
			  return missionList;
		  }
		  if(name.equals(LEVEL5.getLevel())) {
		
			  return missionList;
		  }
		  // 해당레벨에 없는 미션입니다. 
		  throw new IllegalArgumentException();
	  }
}

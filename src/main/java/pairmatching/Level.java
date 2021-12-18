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
		  /*if(level.equals(LEVEL2.getLevel())) {
			  String[] missionList = {"장바구니", "결제", "지하철노선도"};
			  return missionList;
		  }
		  if(level.equals(LEVEL3.getLevel())) {
			  String[] missionList = {};
			  return missionList;
		  }
		  if(level.equals(LEVEL4.getLevel())) {
			  String[] missionList = {"성능개선", "배포"};
			  return missionList;
		  }
		  if(level.equals(LEVEL5.getLevel())) {
			  String[] missionList = {};
			  return missionList;
		  }*/
		  throw new IllegalArgumentException();
	  }
}

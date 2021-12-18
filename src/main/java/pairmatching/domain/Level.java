package pairmatching.domain;

import pairmatching.utils.TestOfLevels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    // 추가 기능 구현

    public static List<Level> getLevelList(){
        return Arrays.stream(Level.values()).collect(Collectors.toList());
    }

    public static String getTestList(String level){
        if(level.equals("레벨1"))    return TestOfLevels.TEST_OF_LEVEL1;
        if(level.equals("레벨2"))    return TestOfLevels.TEST_OF_LEVEL2;
        if(level.equals("레벨3"))    return TestOfLevels.TEST_OF_LEVEL3;
        if(level.equals("레벨4"))    return TestOfLevels.TEST_OF_LEVEL4;
        if(level.equals("레벨5"))    return TestOfLevels.TEST_OF_LEVEL5;
        return null;
    }

    public String getValue(){return name;};


    public static List<String> getLevelLists (){
        List<String> levelList = new ArrayList<String>();
        for(Level level : Level.values()){
            levelList.add(level.getValue());
        }
        return levelList;
    }
}

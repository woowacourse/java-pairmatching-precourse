package pairmatching.domain;

public class Pair {
    private String name;
    private String pairName;
    private String extra;

    public  Pair(String name, String pairName){
        this.name = name;
        this.pairName = pairName;
    }

    public void addExtra(String extraName){
        this.extra = extraName;
    }

    public String getName(){
        return this.name;
    }

    public String getPairName(){
        return this.pairName;
    }

    public String getExtraName(){
        return this.extra;
    }
}

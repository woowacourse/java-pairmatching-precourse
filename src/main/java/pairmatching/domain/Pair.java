package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Pair {
	private List<String[]> pairList;
	public Pair(){
		pairList = new ArrayList<>();
	}

	public void getPair(String name1, String name2){
		pairList.add(new String[]{name1, name2});
	}
	public void getPair(String name1, String name2, String name3){
		pairList.add(new String[]{name1, name2, name3});
	}

	public List<String[]> getPairList(){
		return pairList;
	}
	public void printPair(){
		StringBuilder sb = new StringBuilder();
		for(String[] pair : pairList){
			sb.append(String.join(" : ", pair)).append("\n");
		}
		System.out.println(sb.toString());
	}
}

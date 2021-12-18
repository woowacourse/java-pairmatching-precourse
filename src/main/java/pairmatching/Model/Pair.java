package pairmatching.Model;

import java.util.List;
import java.util.StringJoiner;

import pairmatching.util.Symbol;

public class Pair {
	private List<String> pairMembers;

	public Pair(List<String> pairMembers) {
		this.pairMembers = pairMembers;
	}

	public void addPair(String name){
		this.pairMembers.add(name);
	}

	public List<String> getMember(){
		return pairMembers;
	}


	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner(" : ");
		pairMembers.stream().forEach(s -> joiner.add(s));
		return joiner.toString();
	}
}

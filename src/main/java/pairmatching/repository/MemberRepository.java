package pairmatching.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pairmatching.domain.Member;

public class MemberRepository {
	private Long id = 0L;
	private final Map<Long, Member> members = new HashMap<>();

	public Long save(Member member) {
		members.put(id, member);
		return id++;
	}

	public Member findById(Long id) {
		return members.get(id);
	}

	public List<Member> findAll() {
		return new ArrayList<>(members.values());
	}

	public Member findByName(String name) {
		return members.values().stream()
			.filter(member -> member.getName().equals(name))
			.findFirst().orElse(null);
	}
}

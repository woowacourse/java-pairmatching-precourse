package pairmatching.repository;

import java.util.HashMap;
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
}

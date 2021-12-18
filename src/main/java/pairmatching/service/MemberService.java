package pairmatching.service;

import pairmatching.domain.Member;
import pairmatching.repository.MemberRepository;

public class MemberService {
	private final MemberRepository memberRepository = new MemberRepository();

	public Long save(Member member) {
		return memberRepository.save(member);
	}

	public Member findById(Long id) {
		return memberRepository.findById(id);
	}
}

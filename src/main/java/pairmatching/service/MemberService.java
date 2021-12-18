package pairmatching.service;

import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domain.Course;
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

	public List<Member> findAll() {
		return memberRepository.findAll();
	}

	public List<String> findAllNames() {
		return memberRepository.findAll().stream()
			.map(Member::getName)
			.collect(Collectors.toList());
	}

	public List<String> findAllNamesByCourse(Course course) {
		return memberRepository.findAll().stream()
			.filter(member -> member.getCourse() == course)
			.map(Member::getName)
			.collect(Collectors.toList());
	}

	public Member findByName(String name) {
		return memberRepository.findByName(name);
	}
}

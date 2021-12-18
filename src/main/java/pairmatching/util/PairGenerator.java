package pairmatching.util;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Member;
import pairmatching.domain.Pair;
import pairmatching.domain.PairInfoDto;
import pairmatching.service.MemberService;
import pairmatching.service.PairService;

public class PairGenerator {
	private static final int POSSIBLE_TRIAL_COUNT = 3;

	public static void generate(MemberService memberService, PairInfoDto pairInfoDto,
		PairService pairService) {
		List<String> memberNames = memberService.findAllNamesByCourse(pairInfoDto.getCourse());
		List<String> shuffledMemberNames = Randoms.shuffle(memberNames);
		int trialCount = 0;
		while (trialCount < POSSIBLE_TRIAL_COUNT || trialCount == 0) {
			for (int i = 0; i < shuffledMemberNames.size(); i += 2) {
				List<Member> pairMembers = new ArrayList<>();
				if (shuffledMemberNames.size() == i + 1) {
					pairService.addLastPair(memberService.findByName(shuffledMemberNames.get(i)));
					break;
				}
				pairMembers.add(memberService.findByName(shuffledMemberNames.get(i)));
				pairMembers.add(memberService.findByName(shuffledMemberNames.get(i + 1)));
				Pair pair = new Pair(pairMembers, pairInfoDto.getMission(), pairInfoDto.getCourse());
				if (pairService.isDuplicatedPair(pair)) {
					trialCount += 1;
					break;
				}
				pairService.save(pair);
			}
		}
	}
}

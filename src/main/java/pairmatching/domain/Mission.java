package pairmatching.domain;

import pairmatching.utils.Constants;

public class Mission {
	public final String missionName;
	public Pairs backendPairs;
	public Pairs frontendPairs;

	public Mission(String missionName) {
		this.missionName = missionName;
	}

	public void setPairs(String end, Pairs pairs) {
		if (end.equals(Constants.BACKEND)) {
			backendPairs = pairs;
		}
		if (end.equals(Constants.FRONTEND)) {
			frontendPairs = pairs;
		}
	}

	public Pairs getPairs(String end) {
		if (end.equals(Constants.BACKEND)) {
			return backendPairs;
		}
		if (end.equals(Constants.FRONTEND)) {
			return frontendPairs;
		}
		throw new IllegalArgumentException(Constants.ERROR_MISSION_PATTERN);
	}

	public boolean isEmpty(String end) {
		if (end.equals(Constants.BACKEND) && backendPairs == null) {
			return true;
		}
		return end.equals(Constants.FRONTEND) && frontendPairs == null;
	}

	public void reset() {
		frontendPairs = null;
		backendPairs = null;
	}

	@Override
	public String toString() {
		return missionName;
	}
}

package pairmatching.dto;

public class RequestExecuteFeatureDto {
	private String feature;

	public RequestExecuteFeatureDto(String feature) {
		this.feature = feature;
	}

	public String getMessage() {
		return feature;
	}
}

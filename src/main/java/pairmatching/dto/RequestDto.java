package pairmatching.dto;

public class RequestDto {
    private final String course;
    private final String level;
    private final String mission;

    public RequestDto(String request) {
        String[] requests = request.split(",");
        this.course = requests[0];
        this.level = requests[1];
        this.mission = requests[2];
    }

    public String getCourse() {
        return course;
    }

    public String getLevel() {
        return level;
    }

    public String getMission() {
        return mission;
    }
}

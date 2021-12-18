package pairmatching.domain.validation;

public class Exception {
    private String errorMessage;

    public String getErrorMessage() {
        return ErrorMessage.ERROR + errorMessage;
    }

    public void throwException(String errorMessage) {
        this.errorMessage = errorMessage;
        throw new IllegalArgumentException();
    }
}

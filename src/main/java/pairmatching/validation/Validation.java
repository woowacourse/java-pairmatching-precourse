package pairmatching.validation;

public interface Validation {

    public boolean isValidFunctionListInput(String functionNumberInput);

    public boolean isValidPropertySelectionInput(String propertySelectingInput);

    boolean isValidYesOrNo(String yesOrNoInput);
}

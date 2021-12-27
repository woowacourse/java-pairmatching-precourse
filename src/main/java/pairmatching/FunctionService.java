package pairmatching;

import java.util.ArrayList;

public class FunctionService {
    private static int selectedOption = -1;

    public int getSelectedOption() {
        return selectedOption;
    }

    public boolean isValidFunctionOption(String input) throws IllegalArgumentException {
        ArrayList<Integer> selectedNumberList = isNumberOption(input);
        ArrayList<Integer> selectedNameList = isNameOption(input);
        if (selectedNameList.size() + selectedNumberList.size() >= 2
                || selectedNameList.size() + selectedNumberList.size() == 0) {
            if (!selectedNameList.equals(selectedNumberList)) {
                throw new IllegalArgumentException("[ERROR] 목록에 있는 하나의 옵션을 선택하세요.");
            }
        }
        setSelectedOption(selectedNumberList, selectedNameList);
        return true;
    }

    private void setSelectedOption(ArrayList<Integer> numberList, ArrayList<Integer> nameList) {
        if (numberList.size() == 1) {
            selectedOption = numberList.get(0);
            return;
        }
        selectedOption = nameList.get(0);
    }

    private ArrayList<Integer> isNameOption(String input) {
        ArrayList<Integer> result = new ArrayList<>();
        for (FunctionOption.Number number : FunctionOption.Number.values()) {
            if (input.contains(number.getNumber())) {
                result.add(number.ordinal());
            }
        }
        return result;
    }

    private ArrayList<Integer> isNumberOption(String input) {
        ArrayList<Integer> result = new ArrayList<>();
        for (FunctionOption.Name name : FunctionOption.Name.values()) {
            if (input.contains(name.getName())) {
                result.add(name.ordinal());
            }
        }
        return result;
    }
}

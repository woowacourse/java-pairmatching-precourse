package pairmatching;

import java.util.ArrayList;

public class FunctionService {
    private static int selectedOption = -1;
    private ArrayList<String> functionNameList = new ArrayList<>();
    private ArrayList<String> functionOptionList = new ArrayList<>();

    public FunctionService () {
        initNameList();
        initOptionList();
    }

    private void initNameList() {
        functionNameList.add("페어 매칭");
        functionNameList.add("페어 조회");
        functionNameList.add("페어 초기화");
        functionNameList.add("종료");
    }

    private void initOptionList() {
        functionOptionList.add("1");
        functionOptionList.add("2");
        functionOptionList.add("3");
        functionOptionList.add("Q");
    }

    public void isExistOption(String input) throws IllegalArgumentException {
        int index = 0;
        for (int i = 0; i < functionOptionList.size(); i++) {
            if (functionOptionList.get(i).equals(input)) {
                index = i;
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException("[ERROR] 목록에 있는 옵션을 입력해 주세요.");
        }
        setIndex(index);
    }

    private void setIndex(int index) {
        this.selectedOption = index;
    }

    public int getSelectedOption() {
        return selectedOption;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < functionNameList.size(); i++) {
            result += functionOptionList.get(i) + ". " + functionNameList.get(i) + "\n";
        }
        return result;
    }
}

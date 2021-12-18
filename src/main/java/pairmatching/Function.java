package pairmatching;

import java.util.ArrayList;

public class Function {
    private final MessageService messageService = new MessageService();
    private ArrayList<String> functionNameList = new ArrayList<>();
    private ArrayList<String> functionOptionList = new ArrayList<>();
    private int selectedOption = -1;

    public Function() {
        if (functionNameList.isEmpty()) {
            initNameList();
            initOptionList();
        }
    }

    public boolean isValidOption(String input) {
        try {
            isExist(input);
//            isUnique(input);
            return true;
        } catch (IllegalArgumentException e) {
            messageService.printWithMessage(e.getMessage());
            return false;
        }
    }

    private void isExist(String input) throws IllegalArgumentException {
        int index = -1;
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

//    private void isUnique(String input) throws IllegalArgumentException {
//        int nameIdx = isUniqueName(input);
//        int optionIdx = isUniqueOption(input);
//        if (nameIdx != -1 && optionIdx != -1) {
//            throw new IllegalArgumentException("[ERROR] 목록에 있는 하나의 옵션만 입력해 주세요.");
//        }
//        if (nameIdx == -1 && optionIdx == -1) {
//            throw new IllegalArgumentException("[ERROR] 목록에 있는 옵션을 입력해 주세요.");
//        }
//        setIndex(nameIdx, optionIdx);
//    }

    private void setIndex(int index) {
        selectedOption = index;
    }


    private int isUniqueName(String input) {
        int count = 0;
        int index = 0;
        for (int i = 0; i < functionNameList.size(); i++) {
            if (input.contains(functionNameList.get(i))) {
                count ++;
                index = i;
            }
        }
        if (count > 1) {
            System.out.println("두개 이상 이름");
            return -1;
        }
        return index;
    }

    private int isUniqueOption(String input) throws IllegalArgumentException {
        int count = 0;
        int index = 0;
        for (int i = 0; i < functionOptionList.size(); i++) {
            if (input.contains(functionOptionList.get(i))) {
                count ++;
                index = i;
            }
        }
        if (count == 0) {
            return -1;
        }
        return index;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < functionNameList.size(); i++) {
            result += functionOptionList.get(i) + ". " + functionNameList.get(i) + "\n";
        }
        return result;
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

    public int getSelectedOption() {
        return selectedOption;
    }
}

package pairmatching.view.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Reader {
    public String getString(){
        return Console.readLine();
    }

    public List<String> getStringsWithDelimiter(String delimiter){
        String input = Console.readLine();
        assertNotEndWithDelimiter(input, delimiter);
        return Arrays.stream(input.split(delimiter))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public void assertNotEndWithDelimiter(String input, String delimiter){
        if (input.endsWith(delimiter)) {
            //todo
            throw new IllegalArgumentException("입력 형식 잘못됨");
        }
    }
}

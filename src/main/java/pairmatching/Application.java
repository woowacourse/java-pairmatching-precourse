package pairmatching;

import java.util.ArrayList;
import java.util.List;

import pairmatching.utils.FilePath;
import pairmatching.view.FileInputView;

public class Application {
    public static void main(String[] args) {
        List<String> a = FileInputView.readFile(FilePath.FRONT_END_FILE_ADDRESS.getAddress());
        for (String e : a) {
            System.out.println(e);
        }
    }
}

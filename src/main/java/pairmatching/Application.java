package pairmatching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import pairmatching.model.CrewPair;
import pairmatching.model.Matcher;
import pairmatching.utils.Course;
import pairmatching.utils.FilePath;
import pairmatching.utils.Level;
import pairmatching.utils.Validator;
import pairmatching.view.FileInputView;

public class Application {
    public static void main(String[] args) {
        List<String> a = FileInputView.readFile(FilePath.BACK_END_FILE_ADDRESS.getAddress());
        ArrayList<CrewPair> b = Matcher.match(a);
        for (CrewPair c : b) {
            System.out.println(c);
        }
    }
}

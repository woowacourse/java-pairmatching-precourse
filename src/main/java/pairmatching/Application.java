package pairmatching;

import java.io.FileNotFoundException;

import pairmatching.data.ProgramData;
import pairmatching.io.ConsoleInputHandler;
import pairmatching.io.ConsoleOutputHandler;
import pairmatching.io.FileInputHandler;
import pairmatching.processor.CrewProcessor;
import pairmatching.type.Course;
import pairmatching.type.Crew;
import pairmatching.type.Level;
import pairmatching.type.PairLog;
import pairmatching.util.CrewUtil;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        ConsoleOutputHandler outputHandler = new ConsoleOutputHandler();
        ConsoleInputHandler inputHandler = new ConsoleInputHandler(outputHandler);
        FileInputHandler fileInputHandler = new FileInputHandler();
        CrewProcessor crewProcessor = new CrewProcessor(inputHandler, outputHandler, fileInputHandler);
        PairMatcher pairMatcher = new PairMatcher(crewProcessor, outputHandler, inputHandler);
        pairMatcher.start();
    }
}

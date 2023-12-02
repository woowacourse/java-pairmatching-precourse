package pairmatching;

import org.xml.sax.SAXException;
import pairmatching.controller.PairController;
import pairmatching.domain.Crews;
import pairmatching.domain.Matching;
import pairmatching.service.CrewService;
import pairmatching.service.MatchingService;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Application {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        CrewService crewService = new CrewService(new Crews());
        PairController pairController = new PairController(
                crewService,
                new MatchingService(crewService, new Matching())
        );

        pairController.run();
    }
}

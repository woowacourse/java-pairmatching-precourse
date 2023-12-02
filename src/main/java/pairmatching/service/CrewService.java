package pairmatching.service;

import org.xml.sax.SAXException;
import pairmatching.domain.Crews;
import pairmatching.domain.constants.Course;
import pairmatching.util.MarkdownParser;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class CrewService {
    private final Crews crews;

    public CrewService() throws ParserConfigurationException, IOException, SAXException {
        this.crews = generateCrews();
    }

    public Crews generateCrews() throws ParserConfigurationException, IOException, SAXException {
        MarkdownParser markdownParser = new MarkdownParser();
        List<String> backend = markdownParser.parseName(Course.BACKEND);
        List<String> frontend = markdownParser.parseName(Course.FRONTEND);

        Crews crews = new Crews();
        crews.add(Course.BACKEND, backend);
        crews.add(Course.FRONTEND, frontend);

        return crews;
    }

    public List<String> getCrews(Course course) {
        return crews.getCrews(course);
    }
}

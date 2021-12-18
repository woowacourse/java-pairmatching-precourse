package pairmatching;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        Converter converter = new Converter();

        List<Crew> backendCrews = converter.convertFileToBackEndCrews();
        List<Crew> frontendCrews = converter.convertFileToFrontEndCrews();

        Machine machine = new Machine(backendCrews, frontendCrews);
        machine.run();
    }
}

package pairmatching;

public class Controller {
    Crews crews = new Crews();
    public void start() {
        crews.readFrontend();
        crews.readBackend();
    }
}

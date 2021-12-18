package inputcontroller;

import java.io.*;
import java.util.ArrayList;

import models.Crew;


public class modelGenerator {


    public static void readBackendCrewFromDisk() throws IOException {

        ArrayList<String> backends = new ArrayList<String>();

        InputStream is = modelGenerator.class.getResourceAsStream("/backend-crew.md");
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = reader.readLine()) != null) {
            backends.add(line);
        }
        Crew.generateBackend(backends);
    }

    public static void readFrontendCrewFromDisk() throws IOException {
        ArrayList<String> frontends = new ArrayList<String>();

        InputStream is = modelGenerator.class.getResourceAsStream("/frontend-crew.md");
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = reader.readLine()) != null) {
            frontends.add(line);
        }
        Crew.generateBackend(frontends);
    }
}

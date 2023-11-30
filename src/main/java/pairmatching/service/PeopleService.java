package pairmatching.service;

import static pairmatching.constants.FilePath.*;

import java.util.List;
import pairmatching.constants.FilePath;
import pairmatching.repository.BackendRepository;
import pairmatching.repository.FrontendRepository;
import pairmatching.utils.Reader;

public class PeopleService {
    private final FrontendRepository frontendRepository;
    private final BackendRepository backendRepository;

    public PeopleService() {
        this.frontendRepository = new FrontendRepository();
        this.backendRepository = new BackendRepository();
    }

    public void initPeople(){
        List<String> Frontend = Reader.readFile(FRONT_FILE_PATH.getPath());
        frontendRepository.save(Frontend);
        List<String> Backend = Reader.readFile(BACK_FILE_PATH.getPath());
        backendRepository.save(Backend);
    }

}

package pairmatching.Configuration;

import pairmatching.ConstantDataStore;
import pairmatching.service.MatchingService;
import pairmatching.utils.FileUtility;
import pairmatching.utils.ParsingUtility;
import pairmatching.validation.Validation;
import pairmatching.validation.ValidationImplementation;
import pairmatching.view.InputSystem;
import pairmatching.view.OutputSystem;

public class DependencyInjection {

    public InputSystem inputSystem() {
        return InputSystem.getInstance();
    }

    public OutputSystem outputSystem() {
        return OutputSystem.getInstance();
    }

    public Validation validation() {
        return ValidationImplementation.getInstance();
    }

    public MatchingService matchingService() {
        return MatchingService.getInstance();
    }

    public FileUtility fileUtility() {
        return FileUtility.getInstance();
    }

    public ParsingUtility parsingUtility() {
        return ParsingUtility.getInstance();
    }

    public ConstantDataStore constantDataStore() {
        return ConstantDataStore.getInstance();
    }


}

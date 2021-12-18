package pairmatching.service;

import pairmatching.domain.InputDTO;
import pairmatching.validation.InputValidation;

public class InputService {
    public InputDTO parseInput(String input) {
        String[] infos = input.split(",");
        InputDTO dto = new InputDTO(infos[0], infos[1], infos[2]);
        InputValidation.isValidInput(dto);
        return dto;
    }

    public boolean parseRematch(String input) {
        if (input.equals("네")) {
            return true;
        }
        return false;
    }
}

package com.mowitnow.service;

import com.mowitnow.exception.InvalidInstructionException;
import com.mowitnow.model.Lawn;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class LawnService {

    private static Logger logger = Logger.getLogger(LawnService.class);

    /**
     * creates a lawn initialized according to instruction
     *
     * @param instruction the instruction to initialize the lawn
     * @return the created lawn
     */
    public Lawn initLawn(String instruction) {
        logger.log(Level.INFO, "Init lawn with instruction : " + instruction);
        String[] coordinates = instruction.split(" ");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);
        if (x <= 0 || y <= 0) {
            throw new InvalidInstructionException("Instruction " + instruction
                    + "is not valid for lawn initialization.");
        }
        return new Lawn(x, y);
    }
}

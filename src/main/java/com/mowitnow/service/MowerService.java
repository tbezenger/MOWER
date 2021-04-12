package com.mowitnow.service;

import com.mowitnow.exception.InvalidInstructionException;
import com.mowitnow.model.Lawn;
import com.mowitnow.model.Mower;
import com.mowitnow.model.Orientation;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class MowerService {
    public static final char FORWARD = 'A';
    public static final char LEFT = 'G';
    public static final char RIGHT = 'D';

    private static Logger logger = Logger.getLogger(MowerService.class);

    /**
     * creates a mower initialized according to instruction
     *
     * @param instruction the initialization's instruction
     * @param lawn        the lawn to mow
     * @return the mower
     */
    public Mower initMower(String instruction, Lawn lawn) {
        logger.log(Level.INFO, "Init mower with instruction : " + instruction);
        String[] position = instruction.split(" ");
        int x = Integer.parseInt(position[0]);
        int y = Integer.parseInt(position[1]);
        if (x < 0 || y < 0 || x > lawn.getDimensionX() || y> lawn.getDimensionY()){
            throw new InvalidInstructionException("Instruction " + instruction
            + " invalid, coordinates out of the lawn");
        }
        return new Mower(x, y,
                Orientation.getOrientationByLabel(position[2]),
                lawn);
    }

    /**
     * executes a set of instructions
     *
     * @param mower        the mower which executes the instructions
     * @param instructions the set of instructions to execute
     */
    public void executeInstructions(Mower mower, String instructions) {
        logger.log(Level.INFO, "Execute instructions : " + instructions);
        for (char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case FORWARD:
                    goForward(mower);
                    break;
                case LEFT:
                    turnLeft(mower);
                    break;
                case RIGHT:
                    turnRight(mower);
                    break;
                default:
                    break;
            }
        }
    }

    private void goForward(Mower mower) {
        int x = mower.getX() + mower.getOrientation().getX();
        int y = mower.getY() + mower.getOrientation().getY();
        if (x <= mower.getLawn().getDimensionX()
                && y <= mower.getLawn().getDimensionY()
                && x >= 0 && y >= 0) {
            mower.setX(x);
            mower.setY(y);
        }
    }

    private void turnLeft(Mower mower) {
        Orientation[] orientations = Orientation.values();
        mower.setOrientation(orientations[(mower.getOrientation().ordinal() - 1
                + orientations.length) % orientations.length]);
    }

    private void turnRight(Mower mower) {
        Orientation[] orientations = Orientation.values();
        mower.setOrientation(orientations[(mower.getOrientation().ordinal() + 1
                + orientations.length) % orientations.length]);
    }
}

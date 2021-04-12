package com.mowitnow.service;

import com.mowitnow.exception.InvalidInstructionException;
import com.mowitnow.exception.UndefinedOrientationException;
import com.mowitnow.model.Lawn;
import com.mowitnow.model.Mower;
import com.mowitnow.model.Orientation;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class MowerServiceTest {

    @InjectMocks
    private MowerService mowerService;

    @Test
    public void initMowerWithValidInstruction() {
        Lawn lawn = new Lawn(4, 5);
        Mower expectedMower = new Mower(4, 4, Orientation.NORTH, lawn);
        Mower mower = mowerService.initMower("4 4 N", lawn);
        assertTrue(EqualsBuilder.reflectionEquals(expectedMower, mower, true));
    }

    @Test(expected = InvalidInstructionException.class)
    public void initMowerOutsideLawn() {
        Lawn lawn = new Lawn(4, 5);
        Mower mower = mowerService.initMower("4 8 N", lawn);
    }

    @Test(expected = UndefinedOrientationException.class)
    public void initMowerWithInvalidOrientation() {
        Lawn lawn = new Lawn(4, 5);
        Mower mower = mowerService.initMower("4 4 T", lawn);
    }

    @Test
    public void executeInstructionsWithSomeInvalidInstructions_ShouldContinue() {
        Lawn lawn = new Lawn(4, 5);
        Mower expectedMower = new Mower(4, 4, Orientation.NORTH, lawn);
        Mower mower = mowerService.initMower("4 4 N", lawn);
        mowerService.executeInstructions(mower, "AAGAATAGAAQGADA");
        assertEquals("2 2 S", mower.getPosition());
    }
}
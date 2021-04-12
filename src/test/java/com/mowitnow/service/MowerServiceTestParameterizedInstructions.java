package com.mowitnow.service;

import com.mowitnow.model.Lawn;
import com.mowitnow.model.Mower;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MowerServiceTestParameterizedInstructions {

    @InjectMocks
    private MowerService mowerService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    private final String initMower;
    private final String instructions;
    private final String expectedPosition;
    private final String testedCase;

    public MowerServiceTestParameterizedInstructions(String initMower, String instructions,
                                                     String expectedPosition, String testedCase) {
        this.initMower = initMower;
        this.instructions = instructions;
        this.expectedPosition = expectedPosition;
        this.testedCase = testedCase;
    }

    @Parameterized.Parameters(name = "{3}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"4 4 N", "AGAAAGAAGADA", "2 2 S", "no problem"},
                {"4 4 S", "G", "4 4 E", "test left turn"},
                {"4 4 S", "D", "4 4 W", "test right turn"},
                {"4 4 N", "AAAAAAA", "4 5 N", "do not leave the lawn"},
                {"2 2 W", "LFK5LQ", "2 2 W", "wrong instruction characters"}});
    }

    @Test
    public void executeInstructions() {
        Lawn lawn = new Lawn(4, 5);
        Mower mower = mowerService.initMower(initMower, lawn);
        mowerService.executeInstructions(mower, instructions);
        assertEquals(expectedPosition, mower.getPosition());
    }
}

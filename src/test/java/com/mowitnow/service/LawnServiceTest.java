package com.mowitnow.service;

import com.mowitnow.exception.InvalidInstructionException;
import com.mowitnow.model.Lawn;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LawnServiceTest {

    @InjectMocks
    private LawnService lawnService;

    @Test
    public void initLawnWithValidInstruction() {
        Lawn lawn = lawnService.initLawn("5 7");
        assertEquals(5, lawn.getDimensionX());
        assertEquals(7, lawn.getDimensionY());
    }

    @Test(expected = InvalidInstructionException.class)
    public void initLawnWithInvalidCoordinates() {
        lawnService.initLawn("5 -7");
    }
}

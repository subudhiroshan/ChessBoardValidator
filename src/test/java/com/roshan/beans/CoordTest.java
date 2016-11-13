package com.roshan.beans;

import com.roshan.exception.InvalidCoordException;
import org.junit.Test;

/**
 * Tests for Coord class
 */
public class CoordTest {
    private Coord anyCoord;

    @Test
    public void validCoordTest() throws InvalidCoordException {
        anyCoord = new Coord(0,0);
        anyCoord = new Coord(5,6);
    }

    @Test(expected = InvalidCoordException.class)
    public void invalidXCoordTest() throws InvalidCoordException {
        anyCoord = new Coord(9,1);
    }

    @Test(expected = InvalidCoordException.class)
    public void invalidYCoordTest() throws InvalidCoordException {
        anyCoord = new Coord(2,8);
    }

    @Test(expected = InvalidCoordException.class)
    public void invalidXYCoordTest() throws InvalidCoordException {
        anyCoord = new Coord(9,8);
    }
}
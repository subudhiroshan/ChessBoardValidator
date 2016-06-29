package pieces;

import main.InvalidCoordException;
import main.beans.Coord;
import main.pieces.Horse;
import main.pieces.Minister;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for Horse class
 */
public class HorseTest {
    private Horse aHorse = new Horse();

    @Test
    public void validateHorseMoveTestHP() throws InvalidCoordException {
        Coord coord1 = new Coord(2,3);
        Coord coord2 = new Coord(3,1);
        Coord coord3 = new Coord(3,5);
        Coord coord4 = new Coord(4,7);

        Assert.assertTrue(aHorse.validateMove(coord1, coord2));
        Assert.assertTrue(aHorse.validateMove(coord2, coord1));

        Assert.assertTrue(aHorse.validateMove(coord3, coord4));
        Assert.assertTrue(aHorse.validateMove(coord4, coord3));
    }

    @Test
    public void validateHorseMoveTestInvalid() throws InvalidCoordException {
        Coord coord1 = new Coord(2,3);
        Coord coord2 = new Coord(4,3);
        Coord coord3 = new Coord(1,3);
        Coord coord4 = new Coord(4,6);

        Assert.assertFalse(aHorse.validateMove(coord1, coord1));

        Assert.assertFalse(aHorse.validateMove(coord1, coord2));
        Assert.assertFalse(aHorse.validateMove(coord2, coord1));

        Assert.assertFalse(aHorse.validateMove(coord3, coord4));
        Assert.assertFalse(aHorse.validateMove(coord4, coord3));
    }
}
package pieces;

import main.InvalidCoordException;
import main.beans.Coord;
import main.pieces.Elephant;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for Elephant class
 */
public class ElephantTest {
    private Elephant anElephant = new Elephant();

    @Test
    public void validateElephantMoveTestHP() throws InvalidCoordException {
        Coord coord1 = new Coord(2,3);
        Coord coord2 = new Coord(4,3);
        Coord coord3 = new Coord(1,3);
        Coord coord4 = new Coord(1,6);

        Assert.assertTrue(anElephant.validateMove(coord1, coord2));
        Assert.assertTrue(anElephant.validateMove(coord2, coord1));

        Assert.assertTrue(anElephant.validateMove(coord3, coord4));
        Assert.assertTrue(anElephant.validateMove(coord4, coord3));
    }

    @Test
    public void validateElephantMoveTestInvalid() throws InvalidCoordException {
        Coord coord1 = new Coord(2,3);
        Coord coord2 = new Coord(4,1);
        Coord coord3 = new Coord(3,5);
        Coord coord4 = new Coord(0,2);

        Assert.assertFalse(anElephant.validateMove(coord1, coord1));

        Assert.assertFalse(anElephant.validateMove(coord1, coord2));
        Assert.assertFalse(anElephant.validateMove(coord2, coord1));

        Assert.assertFalse(anElephant.validateMove(coord3, coord4));
        Assert.assertFalse(anElephant.validateMove(coord4, coord3));
    }
}

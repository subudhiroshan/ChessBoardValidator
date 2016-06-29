package pieces;

import main.InvalidCoordException;
import main.beans.Coord;
import main.pieces.Horse;
import main.pieces.Queen;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for Queen class
 */
public class QueenTest {
    private Queen aQueen = new Queen();

    @Test
    public void validateQueenMoveTestHP() throws InvalidCoordException {
        Coord coord1 = new Coord(2,3);
        Coord coord2 = new Coord(4,3);
        Coord coord3 = new Coord(1,3);
        Coord coord4 = new Coord(1,6);
        Coord coord5 = new Coord(4,1);
        Coord coord6 = new Coord(0,2);

        Assert.assertTrue(aQueen.validateMove(coord1, coord2));
        Assert.assertTrue(aQueen.validateMove(coord2, coord1));

        Assert.assertTrue(aQueen.validateMove(coord3, coord4));
        Assert.assertTrue(aQueen.validateMove(coord4, coord3));

        Assert.assertTrue(aQueen.validateMove(coord1, coord5));
        Assert.assertTrue(aQueen.validateMove(coord5, coord1));

        Assert.assertTrue(aQueen.validateMove(coord3, coord6));
        Assert.assertTrue(aQueen.validateMove(coord6, coord3));
    }

    @Test
    public void validateQueenMoveTestInvalid() throws InvalidCoordException {
        Coord coord1 = new Coord(2,3);
        Coord coord2 = new Coord(3,1);
        Coord coord3 = new Coord(3,5);
        Coord coord4 = new Coord(4,7);
        Coord coord5 = new Coord(5,1);
        Coord coord6 = new Coord(6,3);

        Assert.assertFalse(aQueen.validateMove(coord1, coord1));

        Assert.assertFalse(aQueen.validateMove(coord1, coord2));
        Assert.assertFalse(aQueen.validateMove(coord2, coord1));

        Assert.assertFalse(aQueen.validateMove(coord3, coord4));
        Assert.assertFalse(aQueen.validateMove(coord4, coord3));

        Assert.assertFalse(aQueen.validateMove(coord1, coord5));
        Assert.assertFalse(aQueen.validateMove(coord5, coord1));

        Assert.assertFalse(aQueen.validateMove(coord3, coord6));
        Assert.assertFalse(aQueen.validateMove(coord6, coord3));
    }
}
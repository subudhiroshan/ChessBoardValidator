package pieces;

import main.beans.Coord;
import main.pieces.Minister;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for Minister class
 */
public class MinisterTest {
    private Minister aMinister = new Minister();

    @Test
    public void validateMinisterMoveTestHP() {
        Coord coord1 = new Coord(2,3);
        Coord coord2 = new Coord(4,1);
        Coord coord3 = new Coord(3,5);
        Coord coord4 = new Coord(0,2);

        Assert.assertTrue(aMinister.validateMove(coord1, coord2));
        Assert.assertTrue(aMinister.validateMove(coord2, coord1));

        Assert.assertTrue(aMinister.validateMove(coord3, coord4));
        Assert.assertTrue(aMinister.validateMove(coord4, coord3));
    }

    @Test
    public void validateMinisterMoveTestInvalid() {
        Coord coord1 = new Coord(2,3);
        Coord coord2 = new Coord(4,3);
        Coord coord3 = new Coord(1,3);
        Coord coord4 = new Coord(1,6);

        Assert.assertFalse(aMinister.validateMove(coord1, coord1));

        Assert.assertFalse(aMinister.validateMove(coord1, coord2));
        Assert.assertFalse(aMinister.validateMove(coord2, coord1));

        Assert.assertFalse(aMinister.validateMove(coord3, coord4));
        Assert.assertFalse(aMinister.validateMove(coord4, coord3));
    }
}
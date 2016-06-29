package pieces;

import main.beans.Coord;
import main.pieces.Elephant;
import main.pieces.EmptyPiece;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for Elephant class
 */
public class EmptyPieceTest {
    private EmptyPiece someEmptyPiece = new EmptyPiece();

    @Test
    public void validateElephantMoveTestHP() {
        Coord coord1 = new Coord(2,3);
        Coord coord2 = new Coord(4,5);

        Assert.assertTrue(someEmptyPiece.validateMove(coord1, coord1));

        Assert.assertTrue(someEmptyPiece.validateMove(coord1, coord2));
        Assert.assertTrue(someEmptyPiece.validateMove(coord2, coord1));
    }
}
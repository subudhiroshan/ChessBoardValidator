package com.roshan.pieces;

import com.roshan.beans.Coord;
import com.roshan.exception.InvalidCoordException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for Elephant class
 */
public class EmptyPieceTest {
    private EmptyPiece someEmptyPiece = new EmptyPiece();

    @Test
    public void validateElephantMoveTestHP() throws InvalidCoordException {
        Coord coord1 = new Coord(2,3);
        Coord coord2 = new Coord(4,5);

        Assert.assertTrue(someEmptyPiece.validateMove(coord1, coord1));

        Assert.assertTrue(someEmptyPiece.validateMove(coord1, coord2));
        Assert.assertTrue(someEmptyPiece.validateMove(coord2, coord1));
    }
}
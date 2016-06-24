package utils;

import main.beans.Coord;
import main.beans.TeamColor;
import org.junit.Test;

import static main.utils.ChessUtility.*;
import static org.junit.Assert.*;

/**
 * Tests for ChessUtility class
 */
public class ChessUtilityTest {

    @Test
    public void didIMoveTest() throws Exception {

        Coord coord1 = new Coord(1,2);
        Coord coord2 = new Coord(3,4);

        assertFalse(didIMove(coord1, coord1));

        assertTrue(didIMove(coord1, coord2));
        assertTrue(didIMove(coord2, coord1));
    }

    @Test
    public void isDiagonalMoveTest() throws Exception {

        Coord coord1 = new Coord(1,2);
        Coord coord2 = new Coord(3,4);
        Coord coord3 = new Coord(7,7);

        assertFalse(isDiagonalMove(coord1, coord1));

        assertTrue(isDiagonalMove(coord1, coord2));
        assertTrue(isDiagonalMove(coord2, coord1));

        assertFalse(isDiagonalMove(coord1, coord3));
        assertFalse(isDiagonalMove(coord3, coord1));
    }

    @Test
    public void isStraightMoveTest() throws Exception {

        Coord coord1 = new Coord(1,4);
        Coord coord2 = new Coord(3,4);
        Coord coord3 = new Coord(7,7);

        assertFalse(isStraightMove(coord1, coord1));

        assertTrue(isStraightMove(coord1, coord2));
        assertTrue(isStraightMove(coord2, coord1));

        assertFalse(isStraightMove(coord1, coord3));
        assertFalse(isStraightMove(coord3, coord1));
    }

    @Test
    public void isSingleMoveTest() throws Exception {

        Coord coord1 = new Coord(1,4);
        Coord coord2 = new Coord(2,4);
        Coord coord3 = new Coord(3,5);
        Coord coord4 = new Coord(7,7);

        assertFalse(isSingleMove(coord1, coord1));

        assertTrue(isSingleMove(coord1, coord2));
        assertTrue(isSingleMove(coord2, coord1));

        assertTrue(isSingleMove(coord2, coord3));
        assertTrue(isSingleMove(coord3, coord2));

        assertFalse(isSingleMove(coord1, coord4));
        assertFalse(isSingleMove(coord4, coord1));
    }

    @Test
    public void isDoubleForwardMoveTest() throws Exception {

    }

    @Test
    public void isSingleForwardMoveTest() throws Exception {

    }

    @Test
    public void isSoldierKillMoveTest() throws Exception {

    }

    @Test
    public void is2andHalfMoveTest() throws Exception {

        Coord coord1 = new Coord(1,6);
        Coord coord2 = new Coord(2,4);
        Coord coord3 = new Coord(3,2);
        Coord coord4 = new Coord(7,7);

        assertFalse(is2andHalfMove(coord1, coord1));

        assertTrue(is2andHalfMove(coord1, coord2));
        assertTrue(is2andHalfMove(coord2, coord1));

        assertTrue(is2andHalfMove(coord2, coord3));
        assertTrue(is2andHalfMove(coord3, coord2));

        assertFalse(is2andHalfMove(coord1, coord4));
        assertFalse(is2andHalfMove(coord4, coord1));
    }

    @Test
    public void otherTeamColorTest() throws Exception {

        assertEquals(TeamColor.BLACK, otherTeamColor(TeamColor.WHITE));
        assertEquals(TeamColor.WHITE, otherTeamColor(TeamColor.BLACK));
    }

}
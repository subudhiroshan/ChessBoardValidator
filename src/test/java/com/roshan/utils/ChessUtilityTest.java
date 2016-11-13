package com.roshan.utils;

import com.roshan.ChessBoardValidator;
import com.roshan.beans.Coord;
import com.roshan.beans.TeamColor;
import org.junit.Test;

import static com.roshan.utils.ChessUtility.*;
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

        Coord coord1B = new Coord(3,1);
        Coord coord2B = new Coord(5,1);
        Coord coord3B = new Coord(5,3);
        Coord coord4B = new Coord(4,3);

        Coord coord1W = new Coord(3,1);
        Coord coord2W = new Coord(2,6);
        Coord coord3W = new Coord(2,4);
        Coord coord4W = new Coord(3,4);

        ChessBoardValidator.blackOn00 = true;

        assertFalse(isDoubleForwardMove(coord1B, coord1B, TeamColor.BLACK));

        assertTrue(isDoubleForwardMove(coord2B, coord3B, TeamColor.BLACK));
        assertFalse(isDoubleForwardMove(coord3B, coord2B, TeamColor.BLACK));

        assertFalse(isDoubleForwardMove(coord2B, coord4B, TeamColor.BLACK));
        assertFalse(isDoubleForwardMove(coord4B, coord2B, TeamColor.BLACK));


        assertFalse(isDoubleForwardMove(coord1W, coord1W, TeamColor.WHITE));

        assertTrue(isDoubleForwardMove(coord2W, coord3W, TeamColor.WHITE));
        assertFalse(isDoubleForwardMove(coord3W, coord2W, TeamColor.WHITE));

        assertFalse(isDoubleForwardMove(coord2W, coord4W, TeamColor.WHITE));
        assertFalse(isDoubleForwardMove(coord4W, coord2W, TeamColor.WHITE));

        ChessBoardValidator.blackOn00 = false;

        assertFalse(isDoubleForwardMove(coord1B, coord1B, TeamColor.WHITE));

        assertTrue(isDoubleForwardMove(coord2B, coord3B, TeamColor.WHITE));
        assertFalse(isDoubleForwardMove(coord3B, coord2B, TeamColor.WHITE));

        assertFalse(isDoubleForwardMove(coord2B, coord4B, TeamColor.WHITE));
        assertFalse(isDoubleForwardMove(coord4B, coord2B, TeamColor.WHITE));


        assertFalse(isDoubleForwardMove(coord1W, coord1W, TeamColor.BLACK));

        assertTrue(isDoubleForwardMove(coord2W, coord3W, TeamColor.BLACK));
        assertFalse(isDoubleForwardMove(coord3W, coord2W, TeamColor.BLACK));

        assertFalse(isDoubleForwardMove(coord2W, coord4W, TeamColor.BLACK));
        assertFalse(isDoubleForwardMove(coord4W, coord2W, TeamColor.BLACK));
    }

    @Test
    public void isSingleForwardMoveTest() throws Exception {
        Coord coord1B = new Coord(3,1);
        Coord coord2B = new Coord(5,1);
        Coord coord3B = new Coord(5,2);
        Coord coord4B = new Coord(4,2);

        Coord coord1W = new Coord(3,1);
        Coord coord2W = new Coord(2,6);
        Coord coord3W = new Coord(2,5);
        Coord coord4W = new Coord(3,5);

        ChessBoardValidator.blackOn00 = true;

        assertFalse(isSingleForwardMove(coord1B, coord1B, TeamColor.BLACK));

        assertTrue(isSingleForwardMove(coord2B, coord3B, TeamColor.BLACK));
        assertFalse(isSingleForwardMove(coord3B, coord2B, TeamColor.BLACK));

        assertFalse(isSingleForwardMove(coord2B, coord4B, TeamColor.BLACK));
        assertFalse(isSingleForwardMove(coord4B, coord2B, TeamColor.BLACK));


        assertFalse(isSingleForwardMove(coord1W, coord1W, TeamColor.WHITE));

        assertTrue(isSingleForwardMove(coord2W, coord3W, TeamColor.WHITE));
        assertFalse(isSingleForwardMove(coord3W, coord2W, TeamColor.WHITE));

        assertFalse(isSingleForwardMove(coord2W, coord4W, TeamColor.WHITE));
        assertFalse(isSingleForwardMove(coord4W, coord2W, TeamColor.WHITE));

        ChessBoardValidator.blackOn00 = false;

        assertFalse(isSingleForwardMove(coord1B, coord1B, TeamColor.WHITE));

        assertTrue(isSingleForwardMove(coord2B, coord3B, TeamColor.WHITE));
        assertFalse(isSingleForwardMove(coord3B, coord2B, TeamColor.WHITE));

        assertFalse(isSingleForwardMove(coord2B, coord4B, TeamColor.WHITE));
        assertFalse(isSingleForwardMove(coord4B, coord2B, TeamColor.WHITE));


        assertFalse(isSingleForwardMove(coord1W, coord1W, TeamColor.BLACK));

        assertTrue(isSingleForwardMove(coord2W, coord3W, TeamColor.BLACK));
        assertFalse(isSingleForwardMove(coord3W, coord2W, TeamColor.BLACK));

        assertFalse(isSingleForwardMove(coord2W, coord4W, TeamColor.BLACK));
        assertFalse(isSingleForwardMove(coord4W, coord2W, TeamColor.BLACK));
    }

    @Test
    public void isSoldierKillMoveTest() throws Exception {
        Coord coord1B = new Coord(3,1);
        Coord coord2B = new Coord(3,2);
        Coord coord3B = new Coord(4,3);
        Coord coord4B = new Coord(3,3);

        Coord coord1W = new Coord(3,1);
        Coord coord2W = new Coord(5,5);
        Coord coord3W = new Coord(4,4);
        Coord coord4W = new Coord(5,4);

        ChessBoardValidator.blackOn00 = true;

        assertFalse(isSoldierKillMove(coord1B, coord1B, TeamColor.BLACK));

        assertTrue(isSoldierKillMove(coord2B, coord3B, TeamColor.BLACK));
        assertFalse(isSoldierKillMove(coord3B, coord2B, TeamColor.BLACK));

        assertFalse(isSoldierKillMove(coord2B, coord4B, TeamColor.BLACK));
        assertFalse(isSoldierKillMove(coord4B, coord2B, TeamColor.BLACK));


        assertFalse(isSoldierKillMove(coord1W, coord1W, TeamColor.WHITE));

        assertTrue(isSoldierKillMove(coord2W, coord3W, TeamColor.WHITE));
        assertFalse(isSoldierKillMove(coord3W, coord2W, TeamColor.WHITE));

        assertFalse(isSoldierKillMove(coord2W, coord4W, TeamColor.WHITE));
        assertFalse(isSoldierKillMove(coord4W, coord2W, TeamColor.WHITE));

        ChessBoardValidator.blackOn00 = false;

        assertFalse(isSoldierKillMove(coord1B, coord1B, TeamColor.WHITE));

        assertTrue(isSoldierKillMove(coord2B, coord3B, TeamColor.WHITE));
        assertFalse(isSoldierKillMove(coord3B, coord2B, TeamColor.WHITE));

        assertFalse(isSoldierKillMove(coord2B, coord4B, TeamColor.WHITE));
        assertFalse(isSoldierKillMove(coord4B, coord2B, TeamColor.WHITE));


        assertFalse(isSoldierKillMove(coord1W, coord1W, TeamColor.BLACK));

        assertTrue(isSoldierKillMove(coord2W, coord3W, TeamColor.BLACK));
        assertFalse(isSoldierKillMove(coord3W, coord2W, TeamColor.BLACK));

        assertFalse(isSoldierKillMove(coord2W, coord4W, TeamColor.BLACK));
        assertFalse(isSoldierKillMove(coord4W, coord2W, TeamColor.BLACK));
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
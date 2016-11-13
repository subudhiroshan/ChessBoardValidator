package com.roshan.pieces;

import com.roshan.beans.Coord;
import com.roshan.beans.TeamColor;
import com.roshan.ChessBoardValidator;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for Soldier class
 */
public class SoldierTest {
    private Soldier aSoldier = new Soldier();

    @Test
    public void validateSoldierMoveTestHP() throws Exception {
        Coord coord1Up = new Coord(3,1);
        Coord coord2Up = new Coord(3,2);
        Coord coord3Up = new Coord(3,3);
        Coord coord4Up = new Coord(4,2);

        ChessBoardValidator.whiteOn00 = true;
        aSoldier.setTeamColor(TeamColor.BLACK);

        Assert.assertTrue(aSoldier.validateMove(coord1Up, coord2Up));
        Assert.assertFalse(aSoldier.validateMove(coord2Up, coord1Up));

        Assert.assertTrue(aSoldier.validateMove(coord1Up, coord3Up));
        Assert.assertFalse(aSoldier.validateMove(coord3Up, coord1Up));

        Assert.assertTrue(aSoldier.validateMove(coord1Up, coord4Up));
        Assert.assertFalse(aSoldier.validateMove(coord4Up, coord1Up));

        ChessBoardValidator.whiteOn00 = false;
        aSoldier.setTeamColor(TeamColor.WHITE);

        Assert.assertTrue(aSoldier.validateMove(coord1Up, coord2Up));
        Assert.assertFalse(aSoldier.validateMove(coord2Up, coord1Up));

        Assert.assertTrue(aSoldier.validateMove(coord1Up, coord3Up));
        Assert.assertFalse(aSoldier.validateMove(coord3Up, coord1Up));

        Assert.assertTrue(aSoldier.validateMove(coord1Up, coord4Up));
        Assert.assertFalse(aSoldier.validateMove(coord4Up, coord1Up));

        Coord coord1Down = new Coord(2,6);
        Coord coord2Down = new Coord(2,5);
        Coord coord3Down = new Coord(2,4);
        Coord coord4Down = new Coord(3,5);

        ChessBoardValidator.whiteOn00 = false;
        aSoldier.setTeamColor(TeamColor.BLACK);

        Assert.assertTrue(aSoldier.validateMove(coord1Down, coord2Down));
        Assert.assertFalse(aSoldier.validateMove(coord2Down, coord1Down));

        Assert.assertTrue(aSoldier.validateMove(coord1Down, coord3Down));
        Assert.assertFalse(aSoldier.validateMove(coord3Down, coord1Down));

        Assert.assertTrue(aSoldier.validateMove(coord1Down, coord4Down));
        Assert.assertFalse(aSoldier.validateMove(coord4Down, coord1Down));

        ChessBoardValidator.whiteOn00 = true;
        aSoldier.setTeamColor(TeamColor.WHITE);

        Assert.assertTrue(aSoldier.validateMove(coord1Down, coord2Down));
        Assert.assertFalse(aSoldier.validateMove(coord2Down, coord1Down));

        Assert.assertTrue(aSoldier.validateMove(coord1Down, coord3Down));
        Assert.assertFalse(aSoldier.validateMove(coord3Down, coord1Down));

        Assert.assertTrue(aSoldier.validateMove(coord1Down, coord4Down));
        Assert.assertFalse(aSoldier.validateMove(coord4Down, coord1Down));
    }

    @Test
    public void validateSoldierMoveTestInvalid() throws Exception {
        Coord coord1Up = new Coord(3,3);
        Coord coord2Up = new Coord(3,5);
        Coord coord3Up = new Coord(4,3);

        ChessBoardValidator.whiteOn00 = true;
        aSoldier.setTeamColor(TeamColor.BLACK);

        Assert.assertFalse(aSoldier.validateMove(coord1Up, coord1Up));

        Assert.assertFalse(aSoldier.validateMove(coord1Up, coord2Up));
        Assert.assertFalse(aSoldier.validateMove(coord2Up, coord1Up));

        Assert.assertFalse(aSoldier.validateMove(coord1Up, coord3Up));
        Assert.assertFalse(aSoldier.validateMove(coord3Up, coord1Up));

        ChessBoardValidator.whiteOn00 = false;
        aSoldier.setTeamColor(TeamColor.WHITE);

        Assert.assertFalse(aSoldier.validateMove(coord1Up, coord1Up));

        Assert.assertFalse(aSoldier.validateMove(coord1Up, coord2Up));
        Assert.assertFalse(aSoldier.validateMove(coord2Up, coord1Up));

        Assert.assertFalse(aSoldier.validateMove(coord1Up, coord3Up));
        Assert.assertFalse(aSoldier.validateMove(coord3Up, coord1Up));

        Coord coord1Down = new Coord(5,4);
        Coord coord2Down = new Coord(5,2);
        Coord coord3Down = new Coord(6,4);

        ChessBoardValidator.whiteOn00 = false;
        aSoldier.setTeamColor(TeamColor.BLACK);

        Assert.assertFalse(aSoldier.validateMove(coord1Up, coord1Up));

        Assert.assertFalse(aSoldier.validateMove(coord1Down, coord2Down));
        Assert.assertFalse(aSoldier.validateMove(coord2Down, coord1Down));

        Assert.assertFalse(aSoldier.validateMove(coord1Down, coord3Down));
        Assert.assertFalse(aSoldier.validateMove(coord3Down, coord1Down));

        ChessBoardValidator.whiteOn00 = true;
        aSoldier.setTeamColor(TeamColor.WHITE);

        Assert.assertFalse(aSoldier.validateMove(coord1Up, coord1Up));

        Assert.assertFalse(aSoldier.validateMove(coord1Down, coord2Down));
        Assert.assertFalse(aSoldier.validateMove(coord2Down, coord1Down));

        Assert.assertFalse(aSoldier.validateMove(coord1Down, coord3Down));
        Assert.assertFalse(aSoldier.validateMove(coord3Down, coord1Down));
    }
}
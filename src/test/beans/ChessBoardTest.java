package beans;

import main.beans.PieceLocation;
import main.beans.TeamColor;
import org.junit.Test;
import testUtils.ChessTestUtility;

import static main.beans.ChessBoard.getAllPieceLocations;
import static main.beans.ChessBoard.setChessBoardState;
import static org.junit.Assert.*;

/**
 * Tests for ChessBoard class
 */
public class ChessBoardTest {
    @Test
    public void setChessBoardStateTest() throws Exception {
        assertTrue(setChessBoardState(ChessTestUtility.getInitialChessBoardState(true)));
    }

    @Test
    public void getAllPieceLocationsTest() throws Exception {
        setChessBoardState(ChessTestUtility.getInitialChessBoardState(true));

        PieceLocation[] blackLocationsTrue = getAllPieceLocations(TeamColor.BLACK);
        assertTrue(blackLocationsTrue.length == 16);
        for (PieceLocation blackLocation: blackLocationsTrue) {
            assertTrue(blackLocation.getLocation().getY()<2);
        }

        PieceLocation[] whiteLocationsTrue = getAllPieceLocations(TeamColor.WHITE);
        assertTrue(whiteLocationsTrue.length == 16);
        for (PieceLocation whiteLocation: whiteLocationsTrue) {
            assertTrue(whiteLocation.getLocation().getY()>5);
        }

        setChessBoardState(ChessTestUtility.getInitialChessBoardState(false));

        PieceLocation[] blackLocationsFalse = getAllPieceLocations(TeamColor.BLACK);
        assertTrue(blackLocationsFalse.length == 16);
        for (PieceLocation blackLocation: blackLocationsFalse) {
            assertTrue(blackLocation.getLocation().getY()>5);
        }

        PieceLocation[] whiteLocationsFalse = getAllPieceLocations(TeamColor.WHITE);
        assertTrue(whiteLocationsFalse.length == 16);
        for (PieceLocation whiteLocation: whiteLocationsFalse) {
            assertTrue(whiteLocation.getLocation().getY()<2);
        }
    }
}
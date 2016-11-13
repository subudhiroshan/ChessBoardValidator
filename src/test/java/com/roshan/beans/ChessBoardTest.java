package com.roshan.beans;

import com.roshan.utils.ChessBoardUtility;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Tests for ChessBoard class
 */
public class ChessBoardTest {

    private ChessBoard chessBoard = new ChessBoard();

    @Test
    public void setChessBoardStateTest() throws Exception {
        assertTrue(chessBoard.setChessBoardState(ChessBoardUtility.getInitialChessBoardState(true)));
    }

    @Test
    public void getAllPieceLocationsTest() throws Exception {
        chessBoard.setChessBoardState(ChessBoardUtility.getInitialChessBoardState(true));

        PieceLocation[] blackLocationsTrue = chessBoard.getAllPieceLocations(TeamColor.BLACK);
        assertTrue(blackLocationsTrue.length == 16);
        for (PieceLocation blackLocation: blackLocationsTrue) {
            assertTrue(blackLocation.getLocation().getY()<2);
        }

        PieceLocation[] whiteLocationsTrue = chessBoard.getAllPieceLocations(TeamColor.WHITE);
        assertTrue(whiteLocationsTrue.length == 16);
        for (PieceLocation whiteLocation: whiteLocationsTrue) {
            assertTrue(whiteLocation.getLocation().getY()>5);
        }

        chessBoard.setChessBoardState(ChessBoardUtility.getInitialChessBoardState(false));

        PieceLocation[] blackLocationsFalse = chessBoard.getAllPieceLocations(TeamColor.BLACK);
        assertTrue(blackLocationsFalse.length == 16);
        for (PieceLocation blackLocation: blackLocationsFalse) {
            assertTrue(blackLocation.getLocation().getY()>5);
        }

        PieceLocation[] whiteLocationsFalse = chessBoard.getAllPieceLocations(TeamColor.WHITE);
        assertTrue(whiteLocationsFalse.length == 16);
        for (PieceLocation whiteLocation: whiteLocationsFalse) {
            assertTrue(whiteLocation.getLocation().getY()<2);
        }
    }
}
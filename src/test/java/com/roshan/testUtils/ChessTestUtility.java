package com.roshan.testUtils;

import com.roshan.exception.InvalidCoordException;
import com.roshan.beans.Coord;
import com.roshan.beans.PieceLocation;
import com.roshan.beans.TeamColor;
import com.roshan.pieces.*;

import static java.lang.Math.abs;
import static java.lang.Math.floor;

/**
 * Utility methods used on the tests for Chess board
 */
public class ChessTestUtility {

    public static PieceLocation[][] getInitialChessBoardState(boolean blackon00) throws InvalidCoordException {
        PieceLocation[][] initialChessBoard = initializeChessBoard();

        if (blackon00) {
            initialChessBoard[0] = placeNonSoldiersInOneRow(0, TeamColor.BLACK, true);
            initialChessBoard[1] = placeAllSoldiersInOneRow(1, TeamColor.BLACK);
            initialChessBoard[6] = placeAllSoldiersInOneRow(6, TeamColor.WHITE);
            initialChessBoard[7] = placeNonSoldiersInOneRow(7, TeamColor.WHITE, true);
        } else {
            initialChessBoard[0] = placeNonSoldiersInOneRow(0, TeamColor.WHITE, false);
            initialChessBoard[1] = placeAllSoldiersInOneRow(1, TeamColor.WHITE);
            initialChessBoard[6] = placeAllSoldiersInOneRow(6, TeamColor.BLACK);
            initialChessBoard[7] = placeNonSoldiersInOneRow(7, TeamColor.BLACK, false);
        }
        return initialChessBoard;
    }

    private static PieceLocation[][] initializeChessBoard() throws InvalidCoordException {
        PieceLocation[][] blankChessBoard = new PieceLocation[8][8];

        //initialize board with empty com.roshan.pieces
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                Coord iAmHere = new Coord(i, j);

                PieceLocation blankSpot = new PieceLocation();
                blankSpot.setPieceType(new EmptyPiece());
                blankSpot.setLocation(iAmHere);

                blankChessBoard[i][j] = blankSpot;
            }
        }
        return blankChessBoard;
    }

    private static PieceLocation[] placeAllSoldiersInOneRow(int rowNum, TeamColor teamColor) throws InvalidCoordException {
        PieceLocation[] soldierRow = new PieceLocation[8];

        for(int i=0; i<8; i++) {
            Coord iAmHere = new Coord(i, rowNum);
            Soldier aSoldier = new Soldier();
            aSoldier.setTeamColor(teamColor);

            PieceLocation soldierSpot = new PieceLocation();
            soldierSpot.setPieceType(aSoldier);
            soldierSpot.setLocation(iAmHere);

            soldierRow[i] = soldierSpot;
        }
        return soldierRow;
    }

    private static PieceLocation[] placeNonSoldiersInOneRow(int rowNum, TeamColor teamColor, boolean blackOn00) throws InvalidCoordException {
        PieceLocation[] nonSoldierRow = new PieceLocation[8];

        //initializing all the com.roshan.pieces
        Elephant anElephant = new Elephant();
        anElephant.setTeamColor(teamColor);

        Horse aHorse = new Horse();
        aHorse.setTeamColor(teamColor);

        Minister aMinister = new Minister();
        aMinister.setTeamColor(teamColor);

        Queen aQueen = new Queen();
        aQueen.setTeamColor(teamColor);

        King aKing = new King();
        aKing.setTeamColor(teamColor);

        for (int i=0; i<8; i++) {
            Coord iAmHere = new Coord(i, rowNum);

            PieceLocation nonSoldierSpot = new PieceLocation();
            nonSoldierSpot.setLocation(iAmHere);

            switch ((int) floor(abs(3.5-i))) {
                case 3 :
                    nonSoldierSpot.setPieceType(anElephant);
                    nonSoldierRow[i] = nonSoldierSpot;
                    break;
                case 2 :
                    nonSoldierSpot.setPieceType(aHorse);
                    nonSoldierRow[i] = nonSoldierSpot;
                    break;
                case 1 :
                    nonSoldierSpot.setPieceType(aMinister);
                    nonSoldierRow[i] = nonSoldierSpot;
                    break;
                case 0 :
                    PieceLocation nonSoldierSpotKing = new PieceLocation();
                    PieceLocation nonSoldierSpotQueen = new PieceLocation();
                    if (blackOn00) {
                        if (teamColor.equals(TeamColor.BLACK)) {
                            nonSoldierSpotQueen.setPieceType(aQueen);
                            nonSoldierSpotQueen.setLocation(new Coord(3, rowNum));
                            nonSoldierRow[3] = nonSoldierSpotQueen;

                            nonSoldierSpotKing.setPieceType(aKing);
                            nonSoldierSpotKing.setLocation(new Coord(4, rowNum));
                            nonSoldierRow[4] = nonSoldierSpotKing;
                        } else {
                            nonSoldierSpotQueen.setPieceType(aQueen);
                            nonSoldierSpotQueen.setLocation(new Coord(4, rowNum));
                            nonSoldierRow[4] = nonSoldierSpotQueen;

                            nonSoldierSpotKing.setPieceType(aKing);
                            nonSoldierSpotKing.setLocation(new Coord(3, rowNum));
                            nonSoldierRow[3] = nonSoldierSpotKing;
                        }
                    } else {
                        if (teamColor.equals(TeamColor.WHITE)) {
                            nonSoldierSpotQueen.setPieceType(aQueen);
                            nonSoldierSpotQueen.setLocation(new Coord(3, rowNum));
                            nonSoldierRow[3] = nonSoldierSpotQueen;

                            nonSoldierSpotKing.setPieceType(aKing);
                            nonSoldierSpotKing.setLocation(new Coord(4, rowNum));
                            nonSoldierRow[4] = nonSoldierSpotKing;
                        } else {
                            nonSoldierSpotQueen.setPieceType(aQueen);
                            nonSoldierSpotQueen.setLocation(new Coord(4, rowNum));
                            nonSoldierRow[4] = nonSoldierSpotQueen;

                            nonSoldierSpotKing.setPieceType(aKing);
                            nonSoldierSpotKing.setLocation(new Coord(3, rowNum));
                            nonSoldierRow[3] = nonSoldierSpotKing;
                        }
                    }
                    break;
            }
        }
        return nonSoldierRow;
    }
}

package com.roshan.utils;

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
public class ChessBoardUtility {

    public static PieceLocation[][] getInitialChessBoardState(boolean blackon00) throws InvalidCoordException {
        PieceLocation[][] initialChessBoard = initializeChessBoard();

        if (blackon00) {
            initialChessBoard[0] = placeNonSoldiersInOneRow(0, TeamColor.BLACK);
            initialChessBoard[1] = placeAllSoldiersInOneRow(1, TeamColor.BLACK);
            initialChessBoard[6] = placeAllSoldiersInOneRow(6, TeamColor.WHITE);
            initialChessBoard[7] = placeNonSoldiersInOneRow(7, TeamColor.WHITE);
        } else {
            initialChessBoard[0] = placeNonSoldiersInOneRow(0, TeamColor.WHITE);
            initialChessBoard[1] = placeAllSoldiersInOneRow(1, TeamColor.WHITE);
            initialChessBoard[6] = placeAllSoldiersInOneRow(6, TeamColor.BLACK);
            initialChessBoard[7] = placeNonSoldiersInOneRow(7, TeamColor.BLACK);
        }
        return initialChessBoard;
    }

    private static PieceLocation[][] initializeChessBoard() throws InvalidCoordException {
        PieceLocation[][] blankChessBoard = new PieceLocation[8][8];

        //initialize board with empty pieces
        for(int x=0; x<8; x++) {
            for(int y=0; y<8; y++) {
                Coord iAmHere = new Coord(x, y);

                PieceLocation blankSpot = new PieceLocation();
                blankSpot.setPieceType(new EmptyPiece());
                blankSpot.setLocation(iAmHere);

                blankChessBoard[x][y] = blankSpot;
            }
        }
        return blankChessBoard;
    }

    private static PieceLocation[] placeAllSoldiersInOneRow(int rowNum, TeamColor teamColor) throws InvalidCoordException {
        PieceLocation[] soldierRow = new PieceLocation[8];

        for(int x=0; x<8; x++) {
            Coord iAmHere = new Coord(x, rowNum);
            Soldier aSoldier = new Soldier();
            aSoldier.setTeamColor(teamColor);

            PieceLocation soldierSpot = new PieceLocation();
            soldierSpot.setPieceType(aSoldier);
            soldierSpot.setLocation(iAmHere);

            soldierRow[x] = soldierSpot;
        }
        return soldierRow;
    }

    private static PieceLocation[] placeNonSoldiersInOneRow(int rowNum, TeamColor teamColor) throws InvalidCoordException {
        PieceLocation[] nonSoldierRow = new PieceLocation[8];

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

        for (int x=0; x<8; x++) {
            Coord iAmHere = new Coord(x, rowNum);

            PieceLocation nonSoldierSpot = new PieceLocation();
            nonSoldierSpot.setLocation(iAmHere);

            switch ((int) floor(abs(3.5-x))) {
                case 3 :
                    nonSoldierSpot.setPieceType(anElephant);
                    nonSoldierRow[x] = nonSoldierSpot;
                    break;
                case 2 :
                    nonSoldierSpot.setPieceType(aHorse);
                    nonSoldierRow[x] = nonSoldierSpot;
                    break;
                case 1 :
                    nonSoldierSpot.setPieceType(aMinister);
                    nonSoldierRow[x] = nonSoldierSpot;
                    break;
                case 0 :
                    PieceLocation nonSoldierSpotQueen = new PieceLocation();
                    nonSoldierSpotQueen.setPieceType(aQueen);
                    nonSoldierSpotQueen.setLocation(new Coord(3, rowNum));
                    nonSoldierRow[3] = nonSoldierSpotQueen;

                    PieceLocation nonSoldierSpotKing = new PieceLocation();
                    nonSoldierSpotKing.setPieceType(aKing);
                    nonSoldierSpotKing.setLocation(new Coord(4, rowNum));
                    nonSoldierRow[4] = nonSoldierSpotKing;
                    break;
            }
        }
        return nonSoldierRow;
    }
}

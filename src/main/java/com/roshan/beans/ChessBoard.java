package com.roshan.beans;

import com.roshan.pieces.AcChessPiece;

/**
 * Current state of a Chess Board
 */
public class ChessBoard {

    private static PieceLocation[][] chessBoardState;

    public static PieceLocation[][] getChessBoardState() {
        return chessBoardState;
    }

    public static boolean setChessBoardState(PieceLocation[][] chessBoardState) {

        if (chessBoardState.length != 8) {
            return false;
        } else {
            for(int i=0; i<8; i++) {
                if (chessBoardState[i].length != 8) {
                    return false;
                }
            }
        }
        ChessBoard.chessBoardState = chessBoardState;
        return true;
    }

    public static PieceLocation[] getAllPieceLocations(TeamColor team) {
        PieceLocation[] teamState = new PieceLocation[16];
        int k=0;

        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                PieceLocation currentPieceLocation = chessBoardState[i][j];
                AcChessPiece currentPieceType = currentPieceLocation.getPieceType();
                if (currentPieceType.getTeamColor().equals(team)) {
                    teamState[k++] = chessBoardState[i][j];
                }
            }
        }
        return teamState;
    }
}
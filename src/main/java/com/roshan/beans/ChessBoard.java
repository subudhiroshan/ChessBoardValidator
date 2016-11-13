package com.roshan.beans;

import com.roshan.pieces.AcChessPiece;

/**
 * Current state of a Chess Board
 */
public class ChessBoard {

    private PieceLocation[][] chessBoardState;

    public PieceLocation[][] getChessBoardState() {
        return chessBoardState;
    }

    public boolean setChessBoardState(PieceLocation[][] chessBoardState) {

        this.chessBoardState = new PieceLocation[8][8];

        if (chessBoardState.length != 8) {
            return false;
        } else {
            for(int i=0; i<8; i++) {
                if (chessBoardState[i].length != 8) {
                    return false;
                }
                System.arraycopy(chessBoardState[i], 0, this.chessBoardState[i], 0, 8);
            }
        }
        return true;
    }

    public PieceLocation[] getAllPieceLocations(TeamColor team) {
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

    public PieceLocation getPieceAtLocation(Coord location) {
        return chessBoardState[location.getX()][location.getY()];
    }

    public void setPieceAtLocation(PieceLocation pieceLocation, Coord location) {
        chessBoardState[location.getX()][location.getY()] = pieceLocation;
    }
}
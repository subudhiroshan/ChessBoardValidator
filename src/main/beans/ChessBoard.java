package main.beans;

import main.pieces.AcChessPiece;

/**
 * Current state of a Chess Board
 */
public class ChessBoard {

    public static PieceLocation[][] chessBoardState;

    public static PieceLocation[][] getChessBoardState() {
        return chessBoardState;
    }

    public static void setChessBoardState(PieceLocation[][] chessBoardState) {
        ChessBoard.chessBoardState = chessBoardState;
    }

    public static PieceLocation[] getAllPieceLocations(TeamColor team) {
        PieceLocation[] teamState = null;
        int k=0;

        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {

                PieceLocation currentPieceLocation = chessBoardState[i][j];
                AcChessPiece currentPieceType = null;
                try {
                    currentPieceType = currentPieceLocation.getPieceType().newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                if (currentPieceType.getTeamColor().equals(team)) {
                    teamState[k++] = chessBoardState[i][j];
                }
            }
        }
        return teamState;
    }

}
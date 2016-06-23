package main.beans;

/**
 * Current state of a Chess Board
 */
public class ChessBoard {

    public PieceLocation[][] chessBoardState;

    public PieceLocation[][] getChessBoardState() {
        return chessBoardState;
    }

    public void setChessBoardState(PieceLocation[][] chessBoardState) {
        this.chessBoardState = chessBoardState;
    }

    public PieceLocation[] getAllPieceLocations(TeamColor team) {
        private PieceLocation[] teamState = null;
        int k=0;

        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if (chessBoardState[i][j].getPieceType().getTeamColor().equals(team)) {
                    teamState[k++] = chessBoardState[i][j].getPieceType();
                }
            }
        }
        return teamState;
    }

}
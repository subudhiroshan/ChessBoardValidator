package main.pieces;

import main.beans.Coord;
import main.beans.TeamColor;

import static main.utils.ChessUtility.didIMove;
import static main.utils.ChessUtility.isSingleMove;

/**
 * Can move only one step, in any direction
 */
public class King extends AcKingCheck {

    private TeamColor teamColor;

    public TeamColor getTeamColor() {
        return teamColor;
    }

    public void setTeamColor(TeamColor teamColor) {
        this.teamColor = teamColor;
    }

    @Override
    public boolean isCheck(Coord position) {

        PieceLocation[] otherTeamPieceLocations = getAllPieceLocations(ChessUtility.otherTeamColor(this.getTeamColor()));
        for (PieceLocation otherTeamPieceLocation : otherTeamPieceLocations) {
            if (otherTeamPieceLocation.getPieceType().validateMove(otherTeamPieceLocation.getLocation() ,position)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean isCheckMate(Coord position) {

        int checkCount = 0;
        for (Coord possibleLocation : validMovesForKing(position)) {
            if (isCheck(possibleLocation)) {
                checkCount ++;
            }
        }

        return checkCount == 8;
    }

    @Override
    public boolean validateMove(Coord start, Coord end) {

        return didIMove(start, end) && isSingleMove(start, end);

    }

    public Coord[] validMovesForKing(Coord location) {
        Coord[] possibleMoves = null;
        int k=0;

        int currentX = location.getX();
        int currentY = location.getY();

        for(int i=currentX-1; i<currentX+2; i++) {
            for(int j=currentY-1; j<currentY+2; j++) {
                Coord currentLocation = new Coord(i,j);
                if (currentLocation.validateCoord()) {
                    possibleMoves[k++] = currentPosition;
                }
            }
        }

        return possibleMoves;

    }
}

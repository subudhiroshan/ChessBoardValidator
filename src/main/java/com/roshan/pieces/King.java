package com.roshan.pieces;

import com.roshan.exception.InvalidCoordException;
import com.roshan.beans.ChessBoard;
import com.roshan.beans.Coord;
import com.roshan.beans.PieceLocation;
import com.roshan.beans.TeamColor;
import com.roshan.utils.ChessUtility;

import static com.roshan.utils.ChessUtility.didIMove;
import static com.roshan.utils.ChessUtility.isSingleMove;

/**
 * Can move only one step, in any direction
 */
public class King extends AcKingCheck {

    private TeamColor teamColor;

    @Override
    public TeamColor getTeamColor() {
        return teamColor;
    }

    public void setTeamColor(TeamColor teamColor) {
        this.teamColor = teamColor;
    }

    @Override
    public boolean isCheck(Coord position) {

        PieceLocation[] otherTeamPieceLocations = ChessBoard.getAllPieceLocations(ChessUtility.otherTeamColor(this.getTeamColor()));
        for (PieceLocation otherTeamPieceLocation : otherTeamPieceLocations) {
            AcChessPiece currentPieceType = otherTeamPieceLocation.getPieceType();

            if (currentPieceType.validateMove(otherTeamPieceLocation.getLocation() ,position)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isCheckMate(Coord position) throws InvalidCoordException {

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

    private Coord[] validMovesForKing(Coord location) throws InvalidCoordException {
        Coord[] possibleMoves = null;
        int k=0;

        int currentX = location.getX();
        int currentY = location.getY();

        for(int i=currentX-1; i<currentX+2; i++) {
            for(int j=currentY-1; j<currentY+2; j++) {
                Coord currentLocation = new Coord(i,j);
                if (currentLocation.validateCoord()) {
                    possibleMoves[k++] = currentLocation;
                }
            }
        }
        return possibleMoves;
    }

    @Override
    public String toString() {
        return teamColor.toString().substring(0, 1) + " K";
    }
}
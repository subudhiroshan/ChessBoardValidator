package main.pieces;

import main.beans.Coord;
import main.beans.TeamColor;

import static main.utils.ChessUtility.*;

/**
 * Can move diagonally or straight in any direction
 */
public class Queen implements IChessPiece {

    private TeamColor teamColor;

    public TeamColor getTeamColor() {
        return teamColor;
    }

    public void setTeamColor(TeamColor teamColor) {
        this.teamColor = teamColor;
    }

    @Override
    public boolean validateMove(Coord start, Coord end) {
        return didIMove(start, end) && isStraightMove(start, end) || isDiagonalMove(start, end);
    }
}

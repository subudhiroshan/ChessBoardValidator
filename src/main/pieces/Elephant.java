package main.pieces;

import main.beans.Coord;
import main.beans.TeamColor;

import static main.utils.ChessUtility.didIMove;
import static main.utils.ChessUtility.isStraightMove;

/**
 * Can only move in straight lines in any direction
 */
public class Elephant extends AcChessPiece {

    private TeamColor teamColor;

    @Override
    public TeamColor getTeamColor() {
        return teamColor;
    }

    public void setTeamColor(TeamColor teamColor) {
        this.teamColor = teamColor;
    }

    @Override
    public boolean validateMove(Coord start, Coord end) {
        return didIMove(start, end) && isStraightMove(start, end);
    }

    @Override
    public String toString() {
        return teamColor.toString().substring(0, 1) + " E";
    }
}

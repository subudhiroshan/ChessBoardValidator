package main.pieces;

import main.beans.Coord;
import main.beans.TeamColor;

import static main.utils.ChessUtility.didIMove;
import static main.utils.ChessUtility.isDiagonalMove;

/**
 * Can only move diagonally in any direction
 */
public class Minister extends AcChessPiece {

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
        return didIMove(start, end) && isDiagonalMove(start, end);
    }

    @Override
    public String toString() {
        return teamColor.toString().substring(0, 1) + " M";
    }
}

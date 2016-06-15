package main.pieces;

import main.beans.Coord;
import main.beans.TeamColor;

import static main.utils.ChessUtility.didIMove;
import static main.utils.ChessUtility.isDiagonalMove;

/**
 * Can only move diagonally in any direction
 */
public class Minister implements IChessPiece {

    private TeamColor teamColor;

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
}

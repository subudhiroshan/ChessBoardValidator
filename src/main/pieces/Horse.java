package main.pieces;

import main.beans.Coord;
import main.beans.TeamColor;

import static main.utils.ChessUtility.didIMove;
import static main.utils.ChessUtility.is2andHalfMove;

/**
 * Can only move '2-and-half' steps in any direction
 */
public class Horse implements IChessPiece {

    private TeamColor teamColor;

    public TeamColor getTeamColor() {
        return teamColor;
    }

    public void setTeamColor(TeamColor teamColor) {
        this.teamColor = teamColor;
    }

    @Override
    public boolean validateMove(Coord start, Coord end) {

        return didIMove(start, end) && is2andHalfMove(start, end);
    }
}

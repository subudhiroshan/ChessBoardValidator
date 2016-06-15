package main.pieces;

import main.beans.Coord;
import main.beans.TeamColor;

import static main.utils.ChessUtility.*;

/**
 * Can only go forward 1 step, except in the beginning where it can go 2 steps
 * During a kill, it should be a diagonal move
 * Can NEVER move backward
 */

public class Soldier implements IChessPiece {

    private TeamColor teamColor;

    public TeamColor getTeamColor() {
        return teamColor;
    }

    public void setTeamColor(TeamColor teamColor) {
        this.teamColor = teamColor;
    }

    @Override
    public boolean validateMove(Coord start, Coord end) {
        return didIMove(start, end) && isDoubleForwardMove(start, end, teamColor) ||
                isSingleForwardMove(start, end, teamColor) || isSoldierKillMove(start, end, teamColor);
    }
}

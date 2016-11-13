package com.roshan.pieces;

import com.roshan.beans.Coord;
import com.roshan.beans.TeamColor;

import static com.roshan.utils.ChessUtility.*;

/**
 * Can only go forward 1 step, except in the beginning where it can go 2 steps
 * During a kill, it should be a diagonal move
 * Can NEVER move backward
 */

public class Soldier extends AcChessPiece {

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
        return didIMove(start, end) && (isDoubleForwardMove(start, end, teamColor) ||
                isSingleForwardMove(start, end, teamColor) || isSoldierKillMove(start, end, teamColor));
    }

    @Override
    public String toString() {
        return teamColor.toString().substring(0, 1) + " S";
    }
}

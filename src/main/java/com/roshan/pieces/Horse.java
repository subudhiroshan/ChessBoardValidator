package com.roshan.pieces;

import com.roshan.beans.Coord;
import com.roshan.beans.TeamColor;

import static com.roshan.utils.ChessUtility.didIMove;
import static com.roshan.utils.ChessUtility.is2andHalfMove;

/**
 * Can only move '2-and-half' steps in any direction
 */
public class Horse extends AcChessPiece {

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
        return didIMove(start, end) && is2andHalfMove(start, end);
    }

    @Override
    public String toString() {
        return teamColor.toString().substring(0, 1) + " H";
    }
}

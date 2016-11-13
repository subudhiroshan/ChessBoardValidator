package com.roshan.pieces;

import com.roshan.beans.Coord;
import com.roshan.beans.TeamColor;

import static com.roshan.utils.ChessUtility.*;

/**
 * Can move diagonally or straight in any direction
 */
public class Queen extends AcChessPiece {

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
        return didIMove(start, end) && isStraightMove(start, end) || isDiagonalMove(start, end);
    }

    @Override
    public String toString() {
        return teamColor.toString().substring(0, 1) + " Q";
    }
}

package com.roshan.pieces;

import com.roshan.beans.Coord;
import com.roshan.beans.TeamColor;

import static com.roshan.beans.ChessBoard.isUnblockedPath;
import static com.roshan.utils.ChessUtility.didIMove;
import static com.roshan.utils.ChessUtility.isStraightMove;

/**
 * Can only move in straight lines in any direction
 */
public class Elephant extends AcChessPiece {

    private TeamColor teamColor;

    @Override
    public TeamColor getTeamColor() {
        return teamColor;
    }

    @Override
    public void setTeamColor(TeamColor teamColor) {
        this.teamColor = teamColor;
    }

    @Override
    public boolean validateMove(Coord start, Coord end) {
        return didIMove(start, end) && isStraightMove(start, end) && isUnblockedPath(start, end);
    }

    @Override
    public String toString() {
        return teamColor.toString().substring(0, 1) + " E";
    }
}

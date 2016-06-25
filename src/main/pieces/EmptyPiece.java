package main.pieces;

import main.beans.Coord;
import main.beans.TeamColor;

/**
 * Cannot move, does not have any color and indicates a blank spot.
 */
public class EmptyPiece extends AcChessPiece {

    private TeamColor teamColor = TeamColor.NONE;

    @Override
    public TeamColor getTeamColor() {
        return teamColor;
    }

    public void setTeamColor(TeamColor teamColor) {
        this.teamColor = teamColor;
    }

    @Override
    public boolean validateMove(Coord start, Coord end) {
        return true;
    }

    @Override
    public String toString() {
        return "   ";
    }
}

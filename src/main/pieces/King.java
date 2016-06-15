package main.pieces;

import main.beans.Coord;
import main.beans.TeamColor;

import static main.utils.ChessUtility.didIMove;
import static main.utils.ChessUtility.isSingleMove;

/**
 * Can move only one step, in any direction
 */
public class King extends AcKingCheck {

    private TeamColor teamColor;

    public TeamColor getTeamColor() {
        return teamColor;
    }

    public void setTeamColor(TeamColor teamColor) {
        this.teamColor = teamColor;
    }

    @Override
    public boolean isCheck(Coord start, Coord end) {
        return false;
    }

    @Override
    public boolean isCheckMate(Coord start, Coord end) {
        return false;
    }

    @Override
    public boolean validateMove(Coord start, Coord end) {

        return didIMove(start, end) && isSingleMove(start, end);

    }
}

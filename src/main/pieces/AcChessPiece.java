package main.pieces;

import main.beans.Coord;
import main.beans.TeamColor;

/**
 * Created by roshan on 6/23/16.
 */
public abstract class AcChessPiece implements IChessPiece{
    public abstract TeamColor getTeamColor();
    public abstract boolean validateMove(Coord start, Coord end);
}

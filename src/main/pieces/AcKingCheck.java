package main.pieces;

import main.beans.Coord;

/**
 * King can move only if it is not a 'check'/'checkmate'
 */
public abstract class AcKingCheck implements IChessPiece {
    public abstract boolean isCheck(Coord location);
    public abstract boolean isCheckMate(Coord location);
}

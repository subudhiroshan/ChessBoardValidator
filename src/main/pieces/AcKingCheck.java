package main.pieces;

import main.beans.Coord;

/**
 * King can move only if it is not a 'check'/'checkmate'
 */
public abstract class AcKingCheck implements IChessPiece {
    public abstract boolean isCheck(Coord start, Coord end);
    public abstract boolean isCheckMate(Coord start, Coord end);
}

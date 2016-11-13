package com.roshan.pieces;

import com.roshan.beans.Coord;
import com.roshan.beans.TeamColor;

/**
 * Abstract class to define behaviour of a Chess Piece
 */
public abstract class AcChessPiece implements IChessPiece{
    public abstract TeamColor getTeamColor();
    public abstract boolean validateMove(Coord start, Coord end);
}

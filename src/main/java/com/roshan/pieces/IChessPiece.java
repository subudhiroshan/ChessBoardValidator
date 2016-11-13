package com.roshan.pieces;

import com.roshan.beans.Coord;

/**
 * Any chess piece can make only valid moves
 */
public interface IChessPiece {
    public boolean validateMove(Coord start, Coord end);
}

package main.pieces;

import main.beans.Coord;
import main.beans.TeamColor;

/**
 * Any chess piece must be assigned to a color, and can make only valid moves
 */
public interface IChessPiece {
    public boolean validateMove(Coord start, Coord end);
}

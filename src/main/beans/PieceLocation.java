package main.beans;

import main.pieces.IChessPiece;

/**
 * Coordinates and kind of piece on a Chess Board
 */
public class PieceLocation {

    private Coord location;
    private Class pieceType implements IChessPiece;

    public Coord getLocation() {
        return location;
    }

    public void setLocation(Coord location) {
        this.location = location;
    }

    public Class getPieceType() {
        return pieceType;
    }

    public void setPieceType(Class pieceType) {
        this.pieceType = pieceType;
    }

}

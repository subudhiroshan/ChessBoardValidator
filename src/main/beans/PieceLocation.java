package main.beans;

import main.pieces.AcChessPiece;

/**
 * Coordinates and kind of piece on a Chess Board
 */
public class PieceLocation {

    private Coord location;
    private Class<? extends AcChessPiece> pieceType;

    public Coord getLocation() {
        return location;
    }

    public void setLocation(Coord location) {
        this.location = location;
    }

    public Class<? extends AcChessPiece> getPieceType() {
        return pieceType;
    }

    public void setPieceType(Class<? extends AcChessPiece> pieceType) {
        this.pieceType = pieceType;
    }

}

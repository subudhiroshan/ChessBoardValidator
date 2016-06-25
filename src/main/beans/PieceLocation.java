package main.beans;

import main.pieces.AcChessPiece;

/**
 * Coordinates and kind of piece on a Chess Board
 */
public class PieceLocation {

    private Coord location;
    private AcChessPiece pieceType;

    public Coord getLocation() {
        return location;
    }

    public void setLocation(Coord location) {
        this.location = location;
    }

    public AcChessPiece getPieceType() {
        return pieceType;
    }

    public void setPieceType(AcChessPiece pieceType) {
        this.pieceType = pieceType;
    }

}

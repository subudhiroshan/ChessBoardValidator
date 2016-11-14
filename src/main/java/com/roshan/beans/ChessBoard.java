package com.roshan.beans;

import com.roshan.exception.InvalidCoordException;
import com.roshan.pieces.AcChessPiece;
import com.roshan.pieces.EmptyPiece;
import com.roshan.pieces.King;
import com.roshan.utils.ChessUtility;

import static com.roshan.ChessBoardValidator.chessBoard;
import static java.lang.Math.abs;

/**
 * Current state of a Chess Board
 */
public class ChessBoard {

    private PieceLocation[][] chessBoardState;

    public PieceLocation[][] getChessBoardState() {
        return chessBoardState;
    }

    public boolean setChessBoardState(PieceLocation[][] chessBoardState) {

        this.chessBoardState = new PieceLocation[8][8];

        if (chessBoardState.length != 8) {
            return false;
        } else {
            for(int i=0; i<8; i++) {
                if (chessBoardState[i].length != 8) {
                    return false;
                }
                System.arraycopy(chessBoardState[i], 0, this.chessBoardState[i], 0, 8);
            }
        }
        return true;
    }

    public PieceLocation[] getAllPieceLocations(TeamColor team) {
        PieceLocation[] teamState = new PieceLocation[16];
        int k=0;

        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                PieceLocation currentPieceLocation = chessBoardState[i][j];
                AcChessPiece currentPieceType = currentPieceLocation.getPieceType();
                if (currentPieceType.getTeamColor().equals(team)) {
                    teamState[k++] = chessBoardState[i][j];
                }
            }
        }
        return teamState;
    }

    public PieceLocation getPieceAtLocation(Coord location) {
        return chessBoardState[location.getX()][location.getY()];
    }

    public void setPieceAtLocation(PieceLocation pieceLocation) {
        Coord location = pieceLocation.getLocation();
        chessBoardState[location.getX()][location.getY()] = pieceLocation;
    }

    public boolean isCheckmateOfOtherKing(PieceLocation identifiedPiece) throws InvalidCoordException {
        Coord otherKingCoord = otherKingLocation(identifiedPiece);
        King otherKing = new King();
        otherKing.setTeamColor(ChessUtility.otherTeamColor(identifiedPiece.getPieceType().getTeamColor()));
        return otherKing.isCheckMate(otherKingCoord);
    }

    private Coord otherKingLocation(PieceLocation pieceLocation) throws InvalidCoordException {
        TeamColor otherTeamColor = ChessUtility.otherTeamColor(pieceLocation.getPieceType().getTeamColor());
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                PieceLocation currentPieceLocation = chessBoardState[i][j];
                AcChessPiece currentPieceType = currentPieceLocation.getPieceType();
                if (currentPieceType instanceof King &&
                        otherTeamColor.equals(currentPieceType.getTeamColor())) {
                    return new Coord(i, j);
                }
            }
        }
        return null;
    }

    public static boolean isUnblockedPath(Coord A, Coord B) {
        int startX = A.getX();
        int startY = A.getY();
        int endX = B.getX();
        int endY = B.getY();

        try {
            if (startX == endX) {
                int modifierY = ((endY - startY) / abs(endY - startY));
                for (int j = startY + modifierY; j != endY; j += modifierY) {
                    Coord currentCoord = new Coord(endX, j);
                    if (!(chessBoard.getPieceAtLocation(currentCoord).getPieceType() instanceof EmptyPiece)) {
                        return false;
                    }
                }
            } else if (startY == endY) {
                int modifierX = ((endX - startX) / abs(endX - startX));
                for (int i = startX + modifierX; i != endX; i += modifierX) {
                    Coord currentCoord = new Coord(i, endY);
                    if (!(chessBoard.getPieceAtLocation(currentCoord).getPieceType() instanceof EmptyPiece)) {
                        return false;
                    }
                }
            } else {
                int modifierX = ((endX - startX) / abs(endX - startX));
                int modifierY = ((endY - startY) / abs(endY - startY));
                for (int i = startX + modifierX, j = startY + modifierY; i != endX && j != endY;
                     i += modifierX, j += modifierY) {
                    Coord currentCoord = new Coord(i, j);
                    if (!(chessBoard.getPieceAtLocation(currentCoord).getPieceType() instanceof EmptyPiece)) {
                        return false;
                    }
                }
            }
        } catch (InvalidCoordException ice) {
            System.out.println("Invalid coordinates used! " + ice.getMessage());
            ice.printStackTrace();
        }
        return true;
    }
}
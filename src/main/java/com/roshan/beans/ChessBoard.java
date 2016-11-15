package com.roshan.beans;

import com.roshan.exception.InvalidCoordException;
import com.roshan.pieces.AcChessPiece;
import com.roshan.pieces.EmptyPiece;
import com.roshan.pieces.King;

import static com.roshan.ChessBoardValidator.chessBoard;
import static com.roshan.utils.ChessUtility.otherTeamColor;
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
            for(int x=0; x<8; x++) {
                if (chessBoardState[x].length != 8) {
                    return false;
                }
                System.arraycopy(chessBoardState[x], 0, this.chessBoardState[x], 0, 8);
            }
        }
        return true;
    }

    public PieceLocation[] getAllPieceLocations(TeamColor team) {
        PieceLocation[] teamState = new PieceLocation[16];
        int k=0;

        for(int x=0; x<8; x++) {
            for(int y=0; y<8; y++) {
                PieceLocation currentPieceLocation = chessBoardState[x][y];
                AcChessPiece currentPieceType = currentPieceLocation.getPieceType();
                if (currentPieceType.getTeamColor().equals(team)) {
                    teamState[k++] = chessBoardState[x][y];
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

    public boolean isCheckOfYourKing(TeamColor teamColor) throws InvalidCoordException {
        Coord kingCoord = kingLocation(teamColor);
        King king = new King();
        king.setTeamColor(teamColor);
        return king.isCheck(kingCoord);
    }

    public boolean isCheckmateOfOtherKing(TeamColor teamColor) throws InvalidCoordException {
        TeamColor otherTeamColor = otherTeamColor(teamColor);
        Coord otherKingCoord = kingLocation(otherTeamColor);
        King otherKing = new King();
        otherKing.setTeamColor(otherTeamColor(teamColor));
        return otherKing.isCheckMate(otherKingCoord);
    }

    private Coord kingLocation(TeamColor teamColor) throws InvalidCoordException {
        for(int x=0; x<8; x++) {
            for(int y=0; y<8; y++) {
                PieceLocation currentPieceLocation = chessBoardState[x][y];
                AcChessPiece currentPieceType = currentPieceLocation.getPieceType();
                if (currentPieceType instanceof King &&
                        teamColor.equals(currentPieceType.getTeamColor())) {
                    return new Coord(x, y);
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
                for (int y = startY + modifierY; y != endY; y += modifierY) {
                    Coord currentCoord = new Coord(endX, y);
                    if (!(chessBoard.getPieceAtLocation(currentCoord).getPieceType() instanceof EmptyPiece)) {
                        return false;
                    }
                }
            } else if (startY == endY) {
                int modifierX = ((endX - startX) / abs(endX - startX));
                for (int x = startX + modifierX; x != endX; x += modifierX) {
                    Coord currentCoord = new Coord(x, endY);
                    if (!(chessBoard.getPieceAtLocation(currentCoord).getPieceType() instanceof EmptyPiece)) {
                        return false;
                    }
                }
            } else {
                int modifierX = ((endX - startX) / abs(endX - startX));
                int modifierY = ((endY - startY) / abs(endY - startY));
                for (int x = startX + modifierX, y = startY + modifierY; x != endX && y != endY;
                     x += modifierX, y += modifierY) {
                    Coord currentCoord = new Coord(x, y);
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
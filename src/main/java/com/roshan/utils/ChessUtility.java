package com.roshan.utils;

import com.roshan.beans.ChessBoard;
import com.roshan.beans.Coord;
import com.roshan.beans.TeamColor;
import com.roshan.exception.InvalidCoordException;
import com.roshan.pieces.AcChessPiece;
import com.roshan.pieces.EmptyPiece;

import static com.roshan.ChessBoardValidator.blackOn00;
import static com.roshan.ChessBoardValidator.chessBoard;
import static java.lang.Math.*;

/**
 * Utility methods used on the Chess board
 */
public class ChessUtility {

    public static boolean didIMove(Coord A, Coord B) {
        double distance = sqrt((pow(abs(A.getX() - B.getX()), 2)) + (pow(abs(A.getY() - B.getY()), 2)));

        return (distance != 0.0);
    }

    public static boolean isDiagonalMove(Coord A, Coord B) {

        return (didIMove(A, B) && (abs(A.getX() - B.getX()) == abs(A.getY() - B.getY())));
    }

    public static boolean isStraightMove(Coord A, Coord B) {

        return (didIMove(A, B) && ((A.getX() == B.getX()) || (A.getY() == B.getY())));
    }

    private static boolean isSingleStraightMove(Coord A, Coord B) {
        double distance = sqrt((pow(abs(A.getX() - B.getX()), 2)) + (pow(abs(A.getY() - B.getY()), 2)));

        return (distance == 1.0);
    }

    private static boolean isSingleDiagonalMove(Coord A, Coord B) {
        double distance = sqrt((pow(abs(A.getX() - B.getX()), 2)) + (pow(abs(A.getY() - B.getY()), 2)));

        return (distance == sqrt(2.0));
    }

    public static boolean isSingleMove(Coord A, Coord B) {
        return isSingleStraightMove(A, B) || isSingleDiagonalMove(A, B);
    }

    public static boolean isDoubleForwardMove(Coord A, Coord B, TeamColor side) {

        if (!(chessBoard.getPieceAtLocation(B).getPieceType() instanceof EmptyPiece)) {
            return false;
        }

        if (blackOn00) {
            if (side == TeamColor.BLACK) {
                return (A.getX() == 1 && B.getX() == 3) && (A.getY() == B.getY());
            } else if (side == TeamColor.WHITE) {
                return (A.getX() == 6 && B.getX() == 4) && (A.getY() == B.getY());
            } else {
                return false;
            }
        }

        if (side == TeamColor.BLACK) {
            return (A.getX() == 6 && B.getX() == 4) && (A.getY() == B.getY());
        } else if (side == TeamColor.WHITE) {
            return (A.getX() == 1 && B.getX() == 3) && (A.getY() == B.getY());
        } else {
            return false;
        }
    }

    public static boolean isSingleForwardMove(Coord A, Coord B, TeamColor side) {

        if (!(chessBoard.getPieceAtLocation(B).getPieceType() instanceof EmptyPiece)) {
            return false;
        }

        if (blackOn00) {
            if (side == TeamColor.BLACK) {
                return (B.getX() - A.getX() == 1) && (A.getY() == B.getY());
            } else if (side == TeamColor.WHITE) {
                return (B.getX() - A.getX() == -1) && (A.getY() == B.getY());
            } else {
                return false;
            }
        }

        if (side == TeamColor.BLACK) {
            return (B.getX() - A.getX() == -1) && (A.getY() == B.getY());
        } else if (side == TeamColor.WHITE) {
            return (B.getX() - A.getX() == 1) && (A.getY() == B.getY());
        } else {
            return false;
        }
    }

    public static boolean isSoldierKillMove(Coord A, Coord B, TeamColor side) {

        if (chessBoard.getPieceAtLocation(B).getPieceType() instanceof EmptyPiece) {
            return false;
        }

        if (blackOn00) {
            if (side == TeamColor.BLACK) {
                return didIMove(A, B) && (B.getX() - A.getX() == abs(B.getY() - A.getY()));
            } else if (side == TeamColor.WHITE) {
                return didIMove(A, B) && (B.getX() - A.getX() == negateExact(abs(B.getY() - A.getY())));
            } else {
                return false;
            }
        }

        if (side == TeamColor.BLACK) {
            return didIMove(A, B) && (B.getX() - A.getX() == negateExact(abs(B.getY() - A.getY())));
        } else if (side == TeamColor.WHITE) {
            return didIMove(A, B) && (B.getX() - A.getX() == abs(B.getY() - A.getY()));
        } else {
            return false;
        }
    }

    public static boolean is2andHalfMove(Coord A, Coord B) {

        return didIMove(A, B) &&
                (((abs(A.getX() - B.getX()) == 2) && (abs(A.getY() - B.getY()) == 1)) ||
                ((abs(A.getY() - B.getY()) == 2) && (abs(A.getX() - B.getX()) == 1)));
    }

    public static TeamColor otherTeamColor(TeamColor teamColor) {
        if (teamColor.equals(TeamColor.BLACK)) {
            return TeamColor.WHITE;
        }
        return TeamColor.BLACK;
    }

    public static void printChessBoard(ChessBoard chessBoard) {
        System.out.println("X\\Y 0   1   2   3   4   5   6   7 Y/X");
        System.out.println("-------------------------------------");

        for (int x = 0; x < 8; x++) {
            System.out.print(x + " |");
            for (int y = 0; y < 8; y++) {
                AcChessPiece currentPiece = chessBoard.getChessBoardState()[x][y].getPieceType();

                Coord currentCoord = null;
                try {
                    currentCoord = new Coord(x, y);
                } catch (InvalidCoordException ice) {
                    System.out.println("Invalid coordinates used! " + ice.getMessage());
                }

                if (isBlackSquare(currentCoord)) {
                    System.out.print(currentPiece.toString() + "|");
                } else {
                    System.out.print(currentPiece.toString().replace(' ', '.') + "|");
                }
            }
            System.out.print(" " + x);
        System.out.println("\n-------------------------------------");
    }
            System.out.println("X/Y 0   1   2   3   4   5   6   7 Y\\X");
            System.out.println("-------------------------------------");
    }

    private static boolean isBlackSquare(Coord currentCoord) {
        if ((currentCoord.getX() + currentCoord.getY())%2 == 0)
            return blackOn00;
        else
            return !blackOn00;
    }
}

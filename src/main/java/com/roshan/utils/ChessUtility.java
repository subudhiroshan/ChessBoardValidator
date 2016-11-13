package com.roshan.utils;

import com.roshan.beans.ChessBoard;
import com.roshan.beans.Coord;
import com.roshan.beans.TeamColor;
import com.roshan.exception.InvalidCoordException;
import com.roshan.pieces.AcChessPiece;

import static com.roshan.ChessBoardValidator.whiteOn00;
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
        if (whiteOn00) {
            if (side == TeamColor.BLACK) {
                return (A.getY() == 1 && B.getY() == 3) && (A.getX() == B.getX());
            } else if (side == TeamColor.WHITE) {
                return (A.getY() == 6 && B.getY() == 4) && (A.getX() == B.getX());
            } else {
                return false;
            }
        }

        if (side == TeamColor.BLACK) {
            return (A.getY() == 6 && B.getY() == 4) && (A.getX() == B.getX());
        } else if (side == TeamColor.WHITE) {
            return (A.getY() == 1 && B.getY() == 3) && (A.getX() == B.getX());
        } else {
            return false;
        }
    }

    public static boolean isSingleForwardMove(Coord A, Coord B, TeamColor side) {
        if (whiteOn00) {
            if (side == TeamColor.BLACK) {
                return (B.getY() - A.getY() == 1) && (A.getX() == B.getX());
            } else if (side == TeamColor.WHITE) {
                return (B.getY() - A.getY() == -1) && (A.getX() == B.getX());
            } else {
                return false;
            }
        }

        if (side == TeamColor.BLACK) {
            return (B.getY() - A.getY() == -1) && (A.getX() == B.getX());
        } else if (side == TeamColor.WHITE) {
            return (B.getY() - A.getY() == 1) && (A.getX() == B.getX());
        } else {
            return false;
        }
    }

    public static boolean isSoldierKillMove(Coord A, Coord B, TeamColor side) {
        if (whiteOn00) {
            if (side == TeamColor.BLACK) {
                return didIMove(A, B) && (B.getY() - A.getY() == abs(B.getX() - A.getX()));
            } else if (side == TeamColor.WHITE) {
                return didIMove(A, B) && (B.getY() - A.getY() == negateExact(abs(B.getX() - A.getX())));
            } else {
                return false;
            }
        }

        if (side == TeamColor.BLACK) {
            return didIMove(A, B) && (B.getY() - A.getY() == negateExact(abs(B.getX() - A.getX())));
        } else if (side == TeamColor.WHITE) {
            return didIMove(A, B) && (B.getY() - A.getY() == abs(B.getX() - A.getX()));
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
        System.out.println("---------------------------------");

        for(int i=0; i<8; i++) {
            System.out.print("|");
            for(int j=0; j<8; j++) {
                AcChessPiece currentPiece = chessBoard.getChessBoardState()[i][j].getPieceType();

                Coord currentCoord = null;
                try {
                    currentCoord = new Coord(i, j);
                } catch (InvalidCoordException ice) {
                    System.out.println("Invalid coordinates used! " + ice.getMessage());
                }

                if (isBlackSquare(currentCoord)) {
                    System.out.print(currentPiece.toString() + "|");
                } else {
                    System.out.print(currentPiece.toString().replace(' ', '.') + "|");
                }
            }
            System.out.println("\n---------------------------------");
        }
    }

    private static boolean isBlackSquare(Coord currentCoord) {
        if ((currentCoord.getX() + currentCoord.getY())%2 == 0)
            return whiteOn00;
        else
            return !whiteOn00;
    }
}

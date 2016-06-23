package main.utils;

import main.beans.Coord;
import main.beans.TeamColor;

import static java.lang.Math.*;

/**
 * Utility methods used on the Chess board
 */
public class ChessUtility {

    public static boolean didIMove(Coord A, Coord B) {
        double distance = sqrt((pow(abs(A.getX() - B.getX()), 2)) + (pow(abs(A.getY() - B.getY()), 2)));

        return (distance == 0.0);
    }

    public static boolean isDiagonalMove(Coord A, Coord B) {

        return (abs(A.getX() - B.getX()) == abs(A.getY() - B.getY()));
    }

    public static boolean isStraightMove(Coord A, Coord B) {

        return (A.getX() == B.getX()) || (A.getY() == B.getY());
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

    //TODO: make side selection dynamic
    public static boolean isDoubleForwardMove(Coord A, Coord B, TeamColor side) {
        if (side == TeamColor.BLACK) {
            return (A.getY() == 2 && B.getY() == 4);
        } else if (side == TeamColor.WHITE) {
            return (A.getY() == 7 && B.getY() == 5);
        } else {
            return false;
        }
    }

    //TODO: make side selection dynamic
    public static boolean isSingleForwardMove(Coord A, Coord B, TeamColor side) {
        if (side == TeamColor.BLACK) {
            return (B.getY() - A.getY() == 1);
        } else if (side == TeamColor.WHITE) {
            return (B.getY() - A.getY() == -1);
        } else {
            return false;
        }
    }

    //TODO: make side selection dynamic
    public static boolean isSoldierKillMove(Coord A, Coord B, TeamColor side) {
        if (side == TeamColor.BLACK) {
            return (B.getY() - A.getY() == abs(B.getX() - A.getX()));
        } else if (side == TeamColor.WHITE) {
            return (B.getY() - A.getY() == negateExact(abs(B.getX() - A.getX())));
        } else {
            return false;
        }
    }

    public static boolean is2andHalfMove(Coord A, Coord B) {

        return ((abs(A.getX() - B.getX()) == 2) && (abs(A.getY() - B.getY()) == 1)) ||
                ((abs(A.getY() - B.getY()) == 2) && (abs(A.getX() - B.getX()) == 1));
    }

    public static TeamColor otherTeamColor(TeamColor teamColor) {
        if (teamColor.equals(TeamColor.BLACK)) return TeamColor.WHITE;
        if (teamColor.equals(TeamColor.WHITE)) return TeamColor.BLACK;
    }

}

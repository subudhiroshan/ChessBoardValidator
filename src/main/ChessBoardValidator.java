package main;

import main.beans.PieceLocation;
import testUtils.ChessTestUtility;

public class ChessBoardValidator {

    public static boolean blackOn00 = true;

    public static void main(String[] args) {
	    System.out.println("Hello ChessBoardValidator!!!");

        try {
            PieceLocation[][] newChessBoard =
                    ChessTestUtility.getInitialChessBoardState(blackOn00);
            ChessTestUtility.printChessBoard(newChessBoard);
        } catch (InvalidCoordException ice) {
            System.out.println("Invalid coordinates used! " + ice.getMessage());
        }
    }
}

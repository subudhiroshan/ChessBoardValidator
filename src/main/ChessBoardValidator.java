package main;

import main.beans.PieceLocation;
import testUtils.ChessTestUtility;

public class ChessBoardValidator {

    public static boolean blackOn00 = true;

    public static void main(String[] args) {
	    System.out.println("Hello ChessBoardValidator!!!");

        PieceLocation[][] newChessBoard = ChessTestUtility.getInitialChessBoardState(blackOn00);
        ChessTestUtility.printChessBoard(newChessBoard);
    }
}

package com.roshan;

import com.roshan.beans.PieceLocation;
import com.roshan.exception.InvalidCoordException;
import com.roshan.utils.ChessBoardUtility;
import com.roshan.utils.ChessUtility;

public class ChessBoardValidator {

    public static boolean blackOn00 = true;

    public static void main(String[] args) {
	    System.out.println("Hello ChessBoardValidator!!!");

        try {
            PieceLocation[][] newChessBoard =
                    ChessBoardUtility.getInitialChessBoardState(blackOn00);
            ChessUtility.printChessBoard(newChessBoard);
        } catch (InvalidCoordException ice) {
            System.out.println("Invalid coordinates used! " + ice.getMessage());
        }
    }
}

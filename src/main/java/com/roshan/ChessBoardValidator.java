package com.roshan;

import com.roshan.beans.ChessBoard;
import com.roshan.beans.Coord;
import com.roshan.beans.PieceLocation;
import com.roshan.exception.InvalidCoordException;
import com.roshan.pieces.King;
import com.roshan.utils.ChessBoardUtility;
import com.roshan.utils.ChessUtility;

import java.util.Scanner;

public class ChessBoardValidator {

    public static boolean blackOn00 = true;
    private static Scanner scanner = new Scanner(System.in);
    public static ChessBoard chessBoard;

    public static void main(String[] args) {
	    System.out.println("Hello ChessBoardValidator!!!");

        try {
            chessBoard = new ChessBoard();
            chessBoard.setChessBoardState(ChessBoardUtility.getInitialChessBoardState(blackOn00));
            ChessUtility.printChessBoard(chessBoard);

            System.out.println("Please make your move:");
            System.out.println("Start location(x,y) - ");
            String startLoc = scanner.nextLine();
            Coord startCoord = coordFromString(startLoc);

            PieceLocation identifiedPiece = chessBoard.getPieceAtLocation(startCoord);
            System.out.println("Identified piece is " + identifiedPiece.getPieceType().toString());
            System.out.println("End location(x,y) - ");
            String endLoc = scanner.nextLine();
            Coord endCoord = coordFromString(endLoc);

            if (identifiedPiece.getPieceType().validateMove(startCoord, endCoord)) {
                identifiedPiece.setLocation(endCoord);
                chessBoard.setPieceAtLocation(identifiedPiece, endCoord);

                if (checkmateOfOtherKing(identifiedPiece)) {
                    System.out.println("CheckMate. You Win! Congratulations!!!");
                    System.exit(0);
                }

            }

        } catch (InvalidCoordException ice) {
            System.out.println("Invalid coordinates used! " + ice.getMessage());
            ice.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean checkmateOfOtherKing(PieceLocation identifiedPiece) throws InvalidCoordException {
        King otherKing = new King();
        otherKing.setTeamColor(ChessUtility.otherTeamColor(identifiedPiece.getPieceType().getTeamColor()));
        return otherKing.isCheckMate(identifiedPiece.getLocation());
    }

    private static Coord coordFromString(String coordString) throws InvalidCoordException {
        int commaIndex = coordString.indexOf(',');
        return new Coord(Integer.parseInt(coordString.substring(0, commaIndex)), Integer.parseInt(coordString.substring(commaIndex + 1)));
    }
}

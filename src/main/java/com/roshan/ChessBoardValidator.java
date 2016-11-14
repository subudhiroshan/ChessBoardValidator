package com.roshan;

import com.roshan.beans.ChessBoard;
import com.roshan.beans.Coord;
import com.roshan.beans.PieceLocation;
import com.roshan.beans.TeamColor;
import com.roshan.exception.InvalidCoordException;
import com.roshan.pieces.AcChessPiece;
import com.roshan.pieces.EmptyPiece;
import com.roshan.pieces.King;
import com.roshan.utils.ChessBoardUtility;
import com.roshan.utils.ChessUtility;

import java.util.Scanner;

public class ChessBoardValidator {

    public static boolean blackOn00 = true;
    private static Scanner scanner = new Scanner(System.in);
    public static ChessBoard chessBoard;

    public static void main(String[] args) {
        TeamColor teamTurn = TeamColor.BLACK;
        System.out.println("Welcome to ChessBoardValidator!!!\n");

        try {
            chessBoard = new ChessBoard();
            chessBoard.setChessBoardState(ChessBoardUtility.getInitialChessBoardState(blackOn00));
            ChessUtility.printChessBoard(chessBoard);

            while (true) {
                try {

                    System.out.println(teamTurn.toString() + " Please make your move:");
                    System.out.println("Start location(x,y) - ");
                    String startLoc = scanner.nextLine();
                    Coord startCoord = coordFromString(startLoc);
                    PieceLocation startPiece = chessBoard.getPieceAtLocation(startCoord);
                    AcChessPiece startPiecetType = startPiece.getPieceType();
                    System.out.println("Moving [" + startPiecetType.toString() + "]...");

                    if (!startPiecetType.getTeamColor().equals(teamTurn) || startPiecetType instanceof EmptyPiece) {
                        System.out.println(String.format("Wrong move. Please move a %s piece!\n", teamTurn.toString()));
                        continue;
                    }

                    System.out.println("End location(x,y) - ");
                    String endLoc = scanner.nextLine();
                    Coord endCoord = coordFromString(endLoc);
                    PieceLocation endPiece = chessBoard.getPieceAtLocation(endCoord);
                    AcChessPiece endPiecetType = endPiece.getPieceType();

                    if ((startPiecetType instanceof King) && ((King) startPiecetType).isCheck(endCoord)) {
                        System.out.println("Invalid move. King is in Check. Try again!\n");
                    } else if (!startPiecetType.getTeamColor().equals(endPiecetType.getTeamColor()) && startPiecetType.validateMove(startCoord, endCoord)) {
                        System.out.println("Valid move.\n");
                        if (!(endPiecetType instanceof EmptyPiece)) {
                            System.out.println("Awesome! [" + startPiecetType.toString() + "] killed [" + endPiecetType.toString() + "]");
                        }
                        teamTurn = ChessUtility.otherTeamColor(teamTurn);
                        startPiece.setLocation(endCoord);
                        PieceLocation emptyPiece = new PieceLocation();
                        emptyPiece.setPieceType(new EmptyPiece());
                        emptyPiece.setLocation(startCoord);
                        chessBoard.setPieceAtLocation(emptyPiece);
                        chessBoard.setPieceAtLocation(startPiece);

                        if (chessBoard.isCheckmateOfOtherKing(startPiecetType.getTeamColor())) {
                            System.out.println("CheckMate. You Win! Congratulations!!!");
                            ChessUtility.printChessBoard(chessBoard);
                            System.exit(0);
                        }
                    } else {
                        System.out.println("Invalid move. Try again!\n");
                    }

                    ChessUtility.printChessBoard(chessBoard);

                } catch (InvalidCoordException ice) {
                    System.out.println("Invalid coordinates used! " + ice.getMessage());
                    ice.printStackTrace();
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Coord coordFromString(String coordString) throws InvalidCoordException {
        int commaIndex = coordString.indexOf(',');
        if (commaIndex == -1) {
            throw new InvalidCoordException("Please enter coordinates in (X,Y) format!");
        }
        return new Coord(Integer.parseInt(coordString.substring(0, commaIndex)), Integer.parseInt(coordString.substring(commaIndex + 1)));
    }
}

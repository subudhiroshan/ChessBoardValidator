package com.roshan.exception;

/**
 * User-defined InvalidCoordException for invalid chessboard coordinate
 */
public class InvalidCoordException extends Exception{

    public InvalidCoordException() {
        super();
    }

    public InvalidCoordException(String message) {
        super(message);
    }
}

package com.roshan.beans;

import com.roshan.exception.InvalidCoordException;

/**
 * Coordinates of a piece on a Chess Board
 */
public class Coord {

    private int x;
    private int y;

    public Coord(int x, int y) throws InvalidCoordException {
        this.x = x;
        this.y = y;

        if (!this.validateCoord()) {
            throw new InvalidCoordException("Please check the provided coordinates");
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean validateCoord() {
        if ((x<0 || x>7) || (y<0 || y>7)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "(x=" + x + ", y=" + y + ")";
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;

        Coord otherCoord = (Coord) otherObject;

        if (x != otherCoord.x) return false;
        return y == otherCoord.y;
    }

    @Override
    public int hashCode() {
        return 31 + x + y;
    }
}

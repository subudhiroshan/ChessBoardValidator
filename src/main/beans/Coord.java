package main.beans;

/**
 * Coordinates of a piece on a Chess Board
 */
public class Coord {

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    boolean validateCoord() {
        if ((x<1 || x>8) || (y<1 || y>8)) {
            return false;
        }
        return true;
    }
}

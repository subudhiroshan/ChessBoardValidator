package main.beans;

/**
 * Coordinates of a piece on a Chess Board
 */
public class Coord {

    private int x;
    private int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

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
        if ((x<0 || x>7) || (y<0 || y>7)) {
            return false;
        }
        return true;
    }
}

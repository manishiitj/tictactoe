package board;

/**
 * Created by Manish on 9/5/17.
 */
public class Cell {

    int x,y;
    char c;

    public Cell(int x, int y, char c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }
}


package player;

import board.Board;
import board.Cell;

/**
 * Created by Manish on 9/5/17.
 *
 */
public class Player {

    private boolean isFirstPlayer;
    private char playerType;

    public boolean makeAMove(Board board, char type, Cell toCell){

        // check if already occupied
        Cell[][] cells = board.getBoard();

        int x = toCell.getX();
        int y = toCell.getY();

        if( cells[x][y].getC() != ' ' ){
            System.out.print("already occupied");
            return false;
        }
//        char c = toCell.getC();

        cells[x][y] = toCell;

        return true;
    }

    public boolean isFirstPlayer() {
        return isFirstPlayer;
    }

    public void setFirstPlayer(boolean firstPlayer) {
        isFirstPlayer = firstPlayer;
    }

    public enum PlayType{
        X,
        O
    }

    public char getPlayerType() {
        return playerType;
    }

    public void setPlayerType(char playerType) {
        this.playerType = playerType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (isFirstPlayer != player.isFirstPlayer) return false;
        return playerType == player.playerType;
    }

    @Override
    public int hashCode() {
        int result = (isFirstPlayer ? 1 : 0);
        result = 31 * result + (int) playerType;
        return result;
    }
}

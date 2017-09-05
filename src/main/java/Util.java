import board.Board;
import board.Cell;
import board.Pair;
import player.Player;

/**
 * Created by Manish on 9/5/17.
 *
 */
public class Util {



    public static boolean isWinner(char type, Board board1, Pair[][] winnerConfig){

        Cell[][] board = board1.getBoard();
        Pair pair1, pair2, pair3;
        for(int i=0;i<8;i++){

            pair1 = winnerConfig[i][0];
            pair2 = winnerConfig[i][1];
            pair3 = winnerConfig[i][2];

            if(board[pair1.getX()][pair1.getY()].getC() == type && board[pair2.getX()][pair2.getY()].getC() == type && board[pair3.getX()][pair3.getY()].getC() == type ){
                return true;
            }
        }

        return false;

    }

    public static Player getFirstPlayer(Player player1, Player player2){
        int a = (int)Math.random();

        if(a%2 == 0){
            return player1;
        }else{
            return player2;
        }
    }

    public static void announeWinner(char playerType){
        System.out.println("Player: "+ playerType + " is winner");
    }
}

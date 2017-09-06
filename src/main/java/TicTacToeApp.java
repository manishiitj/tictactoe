import board.Board;
import board.Cell;
import board.Pair;
import javafx.application.Application;
import javafx.stage.Stage;
import player.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;

/**
 * Created by Manish on 9/5/17.
 */
public class TicTacToeApp extends Application {
    private Player player1, player2;
    private Board board;
    Pair[][] winnerConfig;

    public void start(Stage primaryStage) throws Exception {


    }

    public static void main(String[] args){
        TicTacToeApp app = new TicTacToeApp();
        System.out.println("Game started");
        app.initializeGame();
        app.startGame();
    }

    private void initializeGame(){
        player1 = new Player();
        player2 = new Player();
        board = new Board();

        if(Util.getFirstPlayer(player1, player2).equals(player1)){
            player1.setFirstPlayer(true);
            player1.setPlayerType('X');
            player2.setPlayerType('O');
        }else{
            player2.setFirstPlayer(true);
            player1.setPlayerType('O');
            player2.setPlayerType('X');
        }
        initializeWinnerConfig();

    }

    public void initializeWinnerConfig(){
        winnerConfig = new Pair[8][3];

        winnerConfig[0][0] = new Pair(0,0);
        winnerConfig[0][1] = new Pair(0,1);
        winnerConfig[0][2] = new Pair(0,2);


        winnerConfig[1][0] = new Pair(1,0);
        winnerConfig[1][1] = new Pair(1,1);
        winnerConfig[1][2] = new Pair(1,2);

        winnerConfig[2][0] = new Pair(2,0);
        winnerConfig[2][1] = new Pair(2,1);
        winnerConfig[2][2] = new Pair(2,2);


        winnerConfig[3][0] = new Pair(0,0);
        winnerConfig[3][1] = new Pair(1,0);
        winnerConfig[3][2] = new Pair(2,0);


        winnerConfig[4][0] = new Pair(0,1);
        winnerConfig[4][1] = new Pair(1,1);
        winnerConfig[4][2] = new Pair(2,1);

        winnerConfig[5][0] = new Pair(0,2);
        winnerConfig[5][1] = new Pair(1,2);
        winnerConfig[5][2] = new Pair(2,2);


        winnerConfig[6][0] = new Pair(0,0);
        winnerConfig[6][1] = new Pair(1,1);
        winnerConfig[6][2] = new Pair(2,2);

        winnerConfig[7][0] = new Pair(2,0);
        winnerConfig[7][1] = new Pair(1,1);
        winnerConfig[7][2] = new Pair(0,2);



        // TODO: 9/5/17 initialize other configs

    }


    public void startGame(){
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);


        int x =0 ,y = 0;
        int chanceCount = 0;
        while(true){
            try {
                x = Integer.parseInt(br.readLine());
                y = Integer.parseInt(br.readLine());
                System.out.println("Inputs are:x: " + x +" y: " + y );
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(player1.isFirstPlayer()){
                if(chanceCount%2 == 0){
                    player1.makeAMove(board, player1.getPlayerType(), new Cell(x,y,player1.getPlayerType()));
                }else{
                    player2.makeAMove(board, player2.getPlayerType(), new Cell(x,y,player2.getPlayerType()));
                }
            }else{
                if(chanceCount %2 == 0){
                    player2.makeAMove(board, player2.getPlayerType(), new Cell(x,y,player2.getPlayerType()));
                }else{
                    player1.makeAMove(board, player1.getPlayerType(), new Cell(x,y,player1.getPlayerType()));
                }

            }

            board.printBoard();
            chanceCount++;
            if(chanceCount >4) {
                if (Util.isWinner(player1.getPlayerType(), board, winnerConfig)) {
                    Util.announeWinner(player1.getPlayerType());
                    break;
                } else if (Util.isWinner(player2.getPlayerType(), board, winnerConfig)) {
                    Util.announeWinner(player2.getPlayerType());
                    break;
                } else {
                    continue;
                }
            }

        }

    }
}

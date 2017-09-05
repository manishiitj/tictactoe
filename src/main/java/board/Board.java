package board;

/**
 * Created by Manish on 9/5/17.
 *
 */
public class Board {

    public Cell[][] board;


    public Board() {
        board = new Cell[3][3];
        initializeBoard();
    }

    public void initializeBoard(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j] = new Cell(i,j,' ');
            }
        }
    }



    public int getSize() {
        return 3;
    }
    public Cell[][] getBoard() {
        return board;
    }

    public void setBoard(Cell[][] board) {
        this.board = board;
    }


    public void printBoard(){
        for(int i= 0; i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(board[i][j].getC()+" ");
            }
            System.out.println();
        }
    }
}

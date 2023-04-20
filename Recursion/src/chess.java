import java.util.Arrays;

public class chess {
    public static void main(String[] args) {
        int[][] chessBoard = new int[8][8];
        solve(chessBoard, 0);

    }

    public static boolean solve(int[][] chessBoard, int col) {
        if(col>=chessBoard[0].length){
            for(short i=0; i<chessBoard.length;i++){
                System.out.println(Arrays.toString(chessBoard[i]));
            }
            return true;
        }

        for (short row =0; row<chessBoard[col].length;row++){
            if(canMove(chessBoard,row,col)){
                chessBoard[row][col]=1;
                if(solve(chessBoard,col+1)) {
                    return true;
                }
                chessBoard[row][col]=0;

            }
        }
        return false;
    }
    public static boolean canMove(int [][]chessBoard,  int row, int col){

        for (int i = 0;  col - i >= 0; i++) {
            if(chessBoard[row][col-i]  ==1 ){
                return false;
            }
        }

        for (int i = 0;  row -i >= 0 && col -i >=0; i++) {
            if(chessBoard[row-i][col-i]  ==1 ){
                return false;
            }
        }

        for(int i = 0; row+i < chessBoard.length && col-i >= 0 ;i++){
            if (chessBoard[row+i][col-i]==1){
                return false;
            }
        }
        return true;
    }


}


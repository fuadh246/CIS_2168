import java.util.Arrays;

public class chess {
    public static void main(String[] args) {
        int[][] chessBoard = new int[8][8];
        solve(chessBoard, 0);

    }

    public static boolean solve(int[][] chessBoard, int pos) {
        if(pos>=chessBoard[0].length){
            for(short i=0; i<chessBoard.length;i++){
                System.out.println(Arrays.toString(chessBoard[i]));
            }
            return true;
        }
        for (short i =0; i<chessBoard[pos].length;i++){
            if(canMove(chessBoard,pos,i)){
                chessBoard[pos][i]=1;
                if(solve(chessBoard,pos+1)) {
                    return true;
                }
                else {
                    chessBoard[pos][i]=1;
                };
            }
        }
        return false;
    }
    public static boolean canMove(int [][]chessBoard,  int row, int col){
        //var
        for (int i = 0; i < chessBoard[col].length; i++) {
            if (chessBoard[i][col] == 1){
                return false;
            }
        }
        //hor
        for (int i = 0; i < chessBoard[row].length; i++) {
            if (chessBoard[row][i] == 1){
                return false;
            }
        }

        return true;
    }
}


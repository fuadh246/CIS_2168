import java.util.Arrays;
public class Sudoku {
    public static void main(String[] args) {
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        int[][] solution = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        int[][] problem96 = {
                {0, 0, 3, 0, 2, 0, 6, 0, 0},
                {9, 0, 0, 3, 0, 5, 0, 0, 1},
                {0, 0, 1, 8, 0, 6, 4, 0, 0},
                {0, 0, 8, 1, 0, 2, 9, 0, 0},
                {7, 0, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 6, 7, 0, 8, 2, 0, 0},
                {0, 0, 2, 6, 0, 9, 5, 0, 0},
                {8, 0, 0, 2, 0, 3, 0, 0, 9},
                {0, 0, 5, 0, 1, 0, 3, 0, 0}
        };
        int[][] problem96solution = {
                {4, 8, 3, 9, 2, 1, 6, 5, 7},
                {9, 6, 7, 3, 4, 5, 8, 2, 1},
                {2, 5, 1, 8, 7, 6, 4, 9, 3},
                {5, 4, 8, 1, 3, 2, 9, 7, 6},
                {7, 2, 9, 5, 6, 4, 1, 3, 8},
                {1, 3, 6, 7, 9, 8, 2, 4, 5},
                {3, 7, 2, 6, 8, 9, 5, 1, 4},
                {8, 1, 4, 2, 5, 3, 7, 6, 9},
                {6, 9, 5, 4, 1, 7, 3, 8, 2}
        };

        solve(problem96, 0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(problem96[i][j]!=problem96solution[i][j]){
                    System.out.println("not equal "+ i+" "+j);
                }
            }
        }
    }
    static boolean solve(int[][] board, int pos) {
        if (pos >= 81) {
            for (int i = 0; i < 9; i++) {
                System.out.println(Arrays.toString(board[i]));
            }
            return true;
        }
        if (board[pos/9][pos%9] != 0){
            return solve(board, pos+1);
        }else{
            for (int i = 1; i < 10; i++) {
                if (validMove(board, i, pos / 9, pos % 9)) {
                    board[pos / 9][pos % 9] = i;
                    if (solve(board, pos + 1)) {
                        return true;
                    } else {
                        board[pos / 9][pos % 9] = 0;
                    }
                }
            }
        }
        return false;
    }
    static boolean validMove(int[][] board, int num, int row, int col) {

        for (int i = 0; i < board[col].length; i++) {
            if (board[i][col] == num){
                return false;
            }
        }

        for (int i = 0; i < board[row].length; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }
        int start_at_row = (row / 3) * 3;
        int start_at_col = (col / 3) * 3;
        for (int i = start_at_row; i < start_at_row + 3; i++) {
            for (int j = start_at_col; j < start_at_col + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}

package moderate;

public class CheckTicTacToe {
    public static int convertBoardToInt(char[][] board) {
        int factor = 1, sum = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int cur = 0;
                if (board[i][j] == 'X') {
                    cur = 1;
                } else if (board[i][j] == 'O') {
                    cur = 2;
                }
                sum += cur * factor;
                factor *= 3;
            }
        }
        return sum;
    }
}

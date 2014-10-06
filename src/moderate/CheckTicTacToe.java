/**
 * CTCI 17.2
 */
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

    public static String convertIntTo3Scale(int data) {
        StringBuilder sb = new StringBuilder();
        while (data > 0) {
            sb.insert(0, data % 3);
            data = data / 3;
        }
        return sb.toString();
    }

    public static int convert3ScaleToInt(String data) {
        int ans = 0;
        for (int i = 0; i < data.length(); i++) {
            ans = ans * 3;
            ans = ans + (data.charAt(i) - '0');
        }
        return ans;
    }

    public static char checkNbyNBoard(char[][] board) {
        int N = board.length, row = 0, col = 0;
        for (row = 0; row < N; row++) {
            if (board[row][0] != '0') {
                for (col = 1; col < N; col++) {
                    if (board[row][col] != board[row][col - 1]) {
                        break;
                    }
                }
                if (col == N) {
                    return board[row][0];
                }
            }
        }
        for (col = 0; col < N; col++) {
            if (board[0][col] != '0') {
                for (row = 1; row < N; row++) {
                    if (board[row][col] != board[row - 1][col]) {
                        break;
                    }
                }
                if (row == N) {
                    return board[0][col];
                }
            }
        }
        if (board[0][0] != '0') {
            for (row = 1; row < N; row++) {
                if (board[row][row] != board[row - 1][row - 1]) {
                    break;
                }
            }
            if (row == N) {
                return board[0][0];
            }
        }
        if (board[N - 1][0] != '0') {
            for (row = 1; row < N; row++) {
                if (board[N - 1 - row][row] != board[N - row][row - 1]) {
                    break;
                }
            }
            if (row == N) {
                return board[N - 1][0];
            }
        }
        return '0';
    }

    public static void main(String[] args) {
        System.out.println(convert3ScaleToInt(convertIntTo3Scale(14)));
    }
}

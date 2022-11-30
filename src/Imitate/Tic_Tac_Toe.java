package Imitate;

public class Tic_Tac_Toe {
    public boolean validTicTacToe(String[] board) {
        int countX = 0, countO = 0;

        for (String s : board) {
            for (int j = 0; j < 3; ++j) {
                if (s.charAt(j) == 'X') {
                    ++countX;
                } else if (s.charAt(j) == 'O') {
                    ++countO;
                }
            }
        }

        boolean a = check(board, 'X'), b = check(board, 'O');

        return !((countO != countX && countO != countX - 1) ||
                (countO != countX - 1) && a ||
                (countO != countX) && b);
    }

    boolean check(String[] board, char c) {
        for (int i = 0; i < 3; ++i) {
            // 三横
            if (board[0].charAt(i) == c && board[1].charAt(i) == c && board[2].charAt(i) == c) {
                return true;
            }
            // 三竖
            if (board[i].charAt(0) == c && board[i].charAt(1) == c && board[i].charAt(2) == c) {
                return true;
            }
        }
        boolean left = c == board[0].charAt(0) && c == board[1].charAt(1) && c == board[2].charAt(2);
        boolean right = c == board[0].charAt(2) && c == board[1].charAt(1) && c == board[2].charAt(0);
        return left || right;
    }
}

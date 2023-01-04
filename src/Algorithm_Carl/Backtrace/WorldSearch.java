package Algorithm_Carl.Backtrace;

/*
时间复杂度：一个非常宽松的上界为 O(MN * 3^L).
其中 M, N 为网格的长度与宽度，L 为字符串 word 的长度。在每次调用函数 check 时，除了第一次可以进入 4 个分支以外，
其余时间我们最多会进入 3 个分支（因为每个位置只能使用一次，所以走过来的分支没法走回去）。
由于单词长为 L，故 check(i,j,0) 的时间复杂度为 O(3^L)，而我们要执行 O(MN) 次检查。
然而，由于剪枝的存在，我们在遇到不匹配或已访问的字符时会提前退出，终止递归流程。
因此，实际的时间复杂度会远远小于 O(MN * 3^L)
 */
public class WorldSearch {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int row, col, len;
    private boolean[][] visited;
    private char[] charArray;
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        visited = new boolean[row][col];

        this.len = word.length();
        this.charArray = word.toCharArray();
        this.board = board;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int x, int y, int begin) {
        if (begin == len - 1) {
            return board[x][y] == charArray[begin];
        }

        if (board[x][y] == charArray[begin]) {
            visited[x][y] = true;
            for (int[] dir : directions) {
                int i = x + dir[0];
                int j = y + dir[1];
                if (isValid(i, j) && !visited[i][j]) {
                    if (dfs(i, j, begin + 1)) {
                        return true;
                    }
                }
            }
            visited[x][y] = false;
        }

        return false;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < row && y < col;
    }
}

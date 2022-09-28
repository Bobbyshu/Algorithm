package yamaxun_ouei.former;

public class RiverControl {
    public static int riverControl(String[] cmds, int n) {
        int row = 0, col = 0;
        for (String cmd : cmds) {
            if (cmd.equals("UP") && row > 0) {
                row--;
            }
            if (cmd.equals("DOWN") && row < n - 1) {
                row++;
            }
            if (cmd.equals("LEFT") && col > 0) {
                col--;
            }
            if (cmd.equals("RIGHT") && col < n - 1) {
                col++;
            }
        }
        return row * n + col;
    }
}

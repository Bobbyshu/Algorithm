package BISHI.Cisco;

public class chessBoard {
    public boolean squareIsWhite(String coordinates) {
        // true for white false for black
        return (coordinates.charAt(0) - '0') % 2 != (int) (coordinates.charAt(1)) % 2;
    }
}

package AIEMC_OUEI;

public class PathExist {
    public static void main(String[] args) {
        PathExist path = new PathExist();
        path.canReach(1, 2, 1, 3, 5);
        System.out.println(path.canReach(1, 2, 1, 3, 5));
    }
    boolean canReach(int c, int sx, int sy, int tx, int ty) {
        while (tx > sx && ty > sy && tx != ty) {
            if (tx > ty) {
                tx %= ty;
            } else {
                ty %= tx;
            }
        }

        if (tx == sx && ty == sy) {
            return true;
        } else if (tx == sx) {
            return ty > sy && ((ty - sy) % tx == 0);
        } else if (ty == sy) {
            return tx > sx && ((tx - sx) % ty == 0);
        } else {
            return false;
        }
    }

    boolean notAllowed(int x) {
        if (x >= 0) {
            double sqrt = Math.pow((double) x, 0.5);
            return sqrt - Math.floor(sqrt) == 0;
        }
        return false;
    }
}

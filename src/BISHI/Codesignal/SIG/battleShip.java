import java.util.*;

public class battleShip {
    public static List<String> solution(char[][] grid, int[][] shots) {
        int rows = grid.length;
        int cols = grid[0].length;
        Map<Character, Set<String>> map = new HashMap<>();
        Set<String> visit = new HashSet<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != '.') {
                    char c = grid[i][j];
                    map.computeIfAbsent(c, k -> new HashSet<>()).add(Arrays.toString(new int[]{i, j}));
                }
            }
        }

        List<String> res = new ArrayList<>();

        for (int[] shot : shots) {
            int row = shot[0], col = shot[1];
            String idx = Arrays.toString(shot);

            if (visit.contains(idx)) {
                res.add("Already attacked");
                continue;
            }

            if (grid[row][col] == '.') {
                res.add("Missed");
            } else {
                visit.add(idx);
                char c = grid[row][col];
                Set<String> cur = map.get(c);
                cur.remove(idx);

                if (cur.isEmpty()) {
                    map.remove(c);
                    res.add("Ship " + c + " sunk");
                } else {
                    res.add("Attacked ship " + c);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        // Example usage
        char[][] grid = {
                {'.', 'A', 'B', 'B', 'B'},
                {'.', 'A', '.', '.', 'C'},
                {'.', '.', '.', '.', '.'},
                {'D', 'D', '.', '.', '.'},
                {'.', 'E', 'E', 'E', 'E'}
        };

        // "Missed", "Attacked ship A", "Attacked ship B", "Ship A sunk", "Already attacked
        // "Ship C sunk","Missed","Missed", "Attacked ship B", "Missed","Ship B sunk"
        int[][] shots = {
                {0, 0}, {0, 1}, {0, 2}, {1, 1}, {0, 1}, {1, 4}, {2, 2}, {2, 4}, {0, 3}, {0, 0}, {0, 4}
        };

        List<String> result = solution(grid, shots);
        for (String r : result) {
            System.out.println(r);
        }
    }
}

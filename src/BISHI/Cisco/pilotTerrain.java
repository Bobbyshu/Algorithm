package BISHI.Cisco;

import java.util.*;
public class pilotTerrain {
    // 考虑重复的点
    public static void funcDrop(int[] xCoordinate, int[] yCoordinate) {
        Map<Integer, Integer> xCount = new HashMap<>();
        Map<Integer, Integer> yCount = new HashMap<>();
        Set<String> uniquePoints = new HashSet<>();
        for (int i = 0; i < xCoordinate.length; i++) {
            xCount.put(xCoordinate[i], xCount.getOrDefault(xCoordinate[i], 0) + 1);
            yCount.put(yCoordinate[i], yCount.getOrDefault(yCoordinate[i], 0) + 1);
            uniquePoints.add(xCoordinate[i] + "," + yCoordinate[i]);
        }
        int maxDrops = Math.max(Collections.max(xCount.values()), Collections.max(yCount.values()));
        // Check if the maxDrops count doesn't exceed the unique points
        if (maxDrops > uniquePoints.size()) {
            maxDrops = uniquePoints.size();
        }
        System.out.println(maxDrops);
    }

    public static void main(String[] args) {
        int[] xCoordinates = {2, 2, 2, 4, 2};
        int[] yCoordinates = {2, 2, 6, 5, 8};
        funcDrop(xCoordinates, yCoordinates);
    }

}

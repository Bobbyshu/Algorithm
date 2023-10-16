package BISHI.GuideWire;

import java.util.HashSet;
import java.util.Set;

public class Domino {
  public static void main(String[] args) {
    String[] arr = {"0-0", "0-1", "2-3", "2-0"};
    System.out.println(solution(arr));
  }
  public static String solution(String[] A) {
    // Create a set to store unique domino tiles
    Set<String> tileSet = new HashSet<>();

    // Add all the tiles from the input array to the set
    for (String tile : A) {
      tileSet.add(tile);
    }

    // Iterate through all possible domino tiles to find one that is not in the set
    for (int i = 0; i <= 6; i++) {
      for (int j = i; j <= 6; j++) {
        String possibleTile = i + "-" + j;
        if (!tileSet.contains(possibleTile) && !tileSet.contains(j + "-" + i)) {
          return possibleTile;
        }
      }
    }

    // A tile should always be found, so this should not be reached
    return "";
  }
}

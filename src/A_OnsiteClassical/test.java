package A_OnsiteClassical;

import java.util.Arrays;

public class test {
  public static void main(String[] args) {
    String[] goodItems = {"matches", "jacket", "blanket", "compass", "pot", "hat", "screwdriver", "fork", "book", "penknife"};
    String[] badItems = {"smartphone", "sword", "axe", "radio", "walkman", "tv", "camera", "boombox", "skateboard", "smartwatch"};
//    int[] arr = new int[26];
//    int[] arr2 = new int[26];
//    for (String s : badItems) {
//      for (char c : s.toCharArray()) {
//        arr[c - 'a']++;
//      }
//    }
//    for (String s : goodItems) {
//      for (char c : s.toCharArray()) {
//        arr2[c - 'a']++;
//      }
//    }
//
//    System.out.println(Arrays.toString(arr));
//    System.out.println(Arrays.toString(arr2));

    String[] regexPatterns = {"et", "he", "ok", "po", "f", "ha", "sc", "pe", "co"};
    for (String s : badItems) {
      for (String m : regexPatterns) {
        if (s.contains(m)) {
          System.out.println(s + " matches " + m);
        }
      }
    }
  }
}

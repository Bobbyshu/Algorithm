package A_OnsiteClassical.Tiktok;

import java.util.*;

public class NO127_WordLadder {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> set = new HashSet<>(wordList);
    if (!set.contains(endWord) || beginWord.equals(endWord)) {
      return 0;
    }

    Deque<String> q = new ArrayDeque<>();
    int step = 0;
    q.addLast(beginWord);

    while (!q.isEmpty()) {
      int size = q.size();

      for (int i = 0; i < size; ++i) {
        String cur = q.pollFirst();
        if (cur.equals(endWord)) {
          return step + 1;
        }

        char[] arr = cur.toCharArray();
        for (int j = 0; j < arr.length; ++j) {
          for (char c = 'a'; c <= 'z'; ++c) {
            char temp = arr[j];
            arr[j] = c;
            if (set.contains(new String(arr))) {
              q.addLast(new String(arr));
              set.remove(new String(arr));
            }
            arr[j] = temp;
          }
        }
      }

      ++step;
    }

    return 0;
  }
}

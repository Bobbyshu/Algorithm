package GuCheng.FundmentalAlgo.B_BFS;

import java.util.*;

public class WordLadderDoubleBFS {
    public int ladderLengthOptimize(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
        Set<String> set = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        if (!set.contains(endWord)) {
            return 0;
        }

        int step = 1, n = beginWord.length();
        beginSet.add(beginWord);
        endSet.add(endWord);

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            Set<String> nextSet = new HashSet<>();
            for (String s : beginSet) {
                char[] ch = s.toCharArray();
                for (int i = 0; i < n; ++i) {
                    for (char c = 'a'; c <= 'z'; ++c) {
                        char pre = ch[i];
                        ch[i] = c;
                        String newOne = new String(ch);
                        if (endSet.contains(newOne)) {
                            return step + 1;
                        }

                        if (visited.add(newOne) && set.contains(newOne)) {
                            nextSet.add(newOne);
                        }
                        ch[i] = pre;
                    }
                }
            }

            //optimize, choose minimum side
            if (endSet.size() < nextSet.size()) {
                //reverse
                beginSet = endSet;
                endSet = nextSet;
            } else {
                beginSet = nextSet;
            }

            ++step;
        }
        return 0;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Deque<String> q = new ArrayDeque<>();
        q.add(beginWord);
        int step = 1, n = beginWord.length();

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                String cur = q.poll();
                if (cur.equals(endWord)) {
                    return step;
                }
                for (int j = 0; j < n; ++j) {
                    for (char c = 'a'; c <= 'z'; ++c) {
                        StringBuilder sb = new StringBuilder(cur);
                        sb.setCharAt(j, c);
                        String newOne = sb.toString();
                        if (set.contains(newOne)) {
                            if (newOne.equals(endWord)) {
                                return step + 1;
                            }

                            set.remove(newOne);
                            q.add(newOne);
                        }
                    }
                }
            }
            ++step;
        }

        return 0;
    }
}

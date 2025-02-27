package A_OnsiteClassical.Tiktok;

import java.util.*;

class NO642_AutoCompleteSystem {
    class TrieNode {
      Map<Character, TrieNode> children;
      Map<String, Integer> counts;
      boolean isWord;
      public TrieNode() {
        children = new HashMap<Character, TrieNode>();
        counts = new HashMap<String, Integer>();
        isWord = false;
      }
    }

    class Pair {
      String s;
      int c;
      public Pair(String s, int c) {
        this.s = s; this.c = c;
      }
    }

    TrieNode root;
    String prefix;


    public NO642_AutoCompleteSystem(String[] sentences, int[] times) {
      root = new TrieNode();
      prefix = "";

      for (int i = 0; i < sentences.length; i++) {
        add(sentences[i], times[i]);
      }
    }

    private void add(String s, int count) {
      TrieNode curr = root;
      for (char c : s.toCharArray()) {
        TrieNode next = curr.children.get(c);
        if (next == null) {
          next = new TrieNode();
          curr.children.put(c, next);
        }
        curr = next;
        curr.counts.put(s, curr.counts.getOrDefault(s, 0) + count);
      }
      curr.isWord = true;
    }

    public List<String> input(char c) {
      if (c == '#') {
        add(prefix, 1);
        prefix = "";
        return new ArrayList<String>();
      }

      prefix = prefix + c;
      TrieNode curr = root;
      for (char cc : prefix.toCharArray()) {
        TrieNode next = curr.children.get(cc);
        if (next == null) {
          return new ArrayList<String>();
        }
        curr = next;
      }

      PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.c == b.c ? a.s.compareTo(b.s) : b.c - a.c));
      for (String s : curr.counts.keySet()) {
        pq.add(new Pair(s, curr.counts.get(s)));
      }

      List<String> res = new ArrayList<String>();
      for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
        res.add(pq.poll().s);
      }
      return res;
    }

}

package DataStructure.Tree.prefixTree;
/*
字典树模板题
每个节点的含义定义为：表示以该路径为前缀的单词数量
构建好了前缀树，如果我们需要查询某个单词的前缀分数和
如 "abc"，只需要路径 abc 的节点累加即可，2 + 2 + 1 = 5
 */
public class lc2416 {
    public int[] sumPrefixScores(String[] words) {
        for (String word : words) {
            insert(word);
        }

        int[] res = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            res[i] = query(words[i]);
        }

        return res;
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int val;
    }

    private final TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (p.children[i] == null) {
                p.children[i] = new TrieNode();
            }
            p.children[i].val += 1;
            p = p.children[i];
        }
    }

    public int query(String word) {
        TrieNode p = root;
        int cnt = 0;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (p.children[i] == null)
                return cnt;

            p = p.children[i];
            cnt += p.val;
        }
        return cnt;
    }
}

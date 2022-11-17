package DataStructure.Tree.prefixTree;

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /*
    先从根结点的子结点开始与 word 第一个字符进行匹配，一直匹配到前缀链上没有对应的字符，
    这时开始不断开辟新的结点，直到插入完 word 的最后一个字符，同时还要将最后一个结点isWord = true;
    表示它是一个单词的末尾。
     */
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    /*
    从根结点的子结点开始，一直向下匹配即可，如果出现结点值为空就返回 false
    如果匹配到了最后一个字符，那我们只需判断 node->isWord即可。
     */
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.isWord;
    }

    /*
    和 search 操作类似，只是不需要判断最后一个字符结点的isEnd，因为既然能匹配到最后一个字符，
    那后面一定有单词是以它为前缀的。
     */
    public boolean startWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return true;
    }
}


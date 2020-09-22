package times_1.trie;

/**
 * @author zhaohongxin
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * 最多插入m或查询m次，时间复杂度，空间复杂度都为O(m)
     */
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i ++) {
            char currChar = word.charAt(i);
            if (!node.containsKey(currChar)) {
                node.put(currChar, new TrieNode());
            }
            node = node.get(currChar);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = prefixNode(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix) {
        return prefixNode(prefix) != null;
    }

    private TrieNode prefixNode(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i ++) {
            char currChar = word.charAt(i);
            if (!node.containsKey(currChar)) {
                return null;
            }
            node = node.get(currChar);
        }
        return node;
    }
}

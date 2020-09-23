package times_1.findwords;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhaohongxin
 */
public class FindWords_212 {
    public List<String> findWords(char[][] board, String[] words) {
        // 初始化前缀树
        Trie root = new Trie();
        for (String word : words) {
            Trie node = root;
            for (int i = 0; i < word.length(); i ++) {
                if (node.next[word.charAt(i) - 'a'] == null) {
                    node.next[word.charAt(i) - 'a'] = new Trie();
                }
                node = node.next[word.charAt(i) - 'a'];
            }
            node.setWord(word);
        }

        List<String> result = new LinkedList<>();
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[i].length; j ++) {
                dfs(i, j, root, result, board);
            }
        }
        return result;
    }

    private void dfs(int row, int col, Trie node, List<String> result, char[][] board) {
        // 终止条件
        node = node.next[board[row][col] - 'a'];
        if (node == null) {
            return;
        }
        if (node.getWord() != null) {
            result.add(node.getWord());
            node.setWord(null);
        }
        char tmp = board[row][col];
        board[row][col] = '#';

        int[] rowChange = {1, 0, -1, 0};
        int[] colChange = {0, 1, 0, -1};
        for (int i = 0; i < 4; i ++) {
            int newRow = row + rowChange[i];
            int newCol = col + colChange[i];
            if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length || board[newRow][newCol] == '#') {
                continue;
            }
            dfs(newRow, newCol, node, result, board);
        }
        // 改变状态
        board[row][col] = tmp;
    }
    class Trie {
        public Trie[] next;
        private String word;
        public Trie() {
            next = new Trie[26];
        }
        public void setWord(String word) {
            this.word = word;
        }
        public String getWord() {
            return this.word;
        }
    }
    public static void main(String[] args) {
        char[][] board =  {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};

        FindWords_212 a = new FindWords_212();
        List<String> words1 = a.findWords(board, words);
        System.out.println(words1);
    }

}




package times_1.ladderlength;

import java.util.*;

/**
 * @author zhaohongxin
 */
public class LadderLength {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> targetSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int step = 0;
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int len = beginWord.length();
        while (!queue.isEmpty()) {
            int queSize = queue.size();
            for (int i = 0; i < queSize; i ++) {
                String currWord = queue.poll();
                if (hasResult(queue, currWord, endWord, visited, targetSet, len)) {
                    return step + 1;
                }
            }
            step ++;
        }
        return 0;
    }

    private boolean hasResult(Queue<String> queue, String currWord, String endWord,
                              Set<String> visited, Set<String> targetSet, int len) {

        char[] currCharArray = currWord.toCharArray();
        for (int i = 0; i < len; i ++) {
            char tmp = currCharArray[i];
            for (char k = 'a'; k <= 'z'; k ++) {
                if (tmp == 'k') {
                    continue;
                }
                currCharArray[i] = k;

                String tryWord = new String(currCharArray);
                if (targetSet.contains(tryWord)) {
                    if (tryWord.equals(endWord)) {
                        return true;
                    }
                    if (!visited.contains(tryWord)) {
                        queue.add(tryWord);
                        visited.add(tryWord);
                    }
                }
            }
            currCharArray[i] = tmp;
        }
        return false;
    }
}

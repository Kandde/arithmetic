package times_1.lengthoflongestsubstring;

import java.util.HashSet;

/**
 * @author zhaohongxin
 */
public class LengthOfLongestSubstring {
    public int solution(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (set.size() < j - i) {
                    break;
                }
                set.add(s.charAt(j));
                result = max(result, set.size());
            }
            if (set.size() == s.length()) {
                result = s.length();
            }
        }
        return result;
    }
    private int max(int a, int b) {
        return (a >= b) ? a : b;
    }
}

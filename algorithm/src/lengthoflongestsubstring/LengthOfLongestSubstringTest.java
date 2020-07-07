package lengthoflongestsubstring;

import org.junit.Assert;
import org.junit.Test;


class LengthOfLongestSubstringTest {
    @Test
    public void solutionTest() {
        int r1 = new LengthOfLongestSubstring().solution("abcabcbb");
        Assert.assertEquals(r1, 3);
    }

    public static void main(String[] args) {
        int r1 = new LengthOfLongestSubstring().solution("abcabcbb");
    }
}
package times_1.uniquepaths;

import java.util.Arrays;

/**
 * @author zhaohongxin
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.fill(dp[m-1], 1);
        for (int i = 0; i < m; i ++) {
            dp[i][n-1] = 1;
        }
        for (int i = m - 2; i >= 0; i --) {
            for (int j = n - 2; j >= 0; j --) {
                dp[i][j] = dp[i +1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }

    public int[] solution(String S, char C) {
        int n = S.length();
        int[] res = new int[n];
        int pos = -n;
        for (int i = 0; i < n; i ++) {
            if (S.charAt(i) == C) {
                pos = i;
            }
            res[i] = i - pos;
        }
        for (int i = pos; i >= 0; i --) {
            if (S.charAt(i) == C) {
                pos = i;
            }
            res[i] = Math.min(pos - i, res[i]);
        }
        return res;
    }

    public static void main(String[] args) {

        UniquePaths u = new UniquePaths();
        int[] solution = u.solution("lovewejoydaeta", 'e');
        for (int s:
             solution) {
            System.out.println(s);
        }
    }
}

package times_1.solvenqueens;

import java.util.*;

/**
 * @author zhaohongxin
 */
public class SolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        Set<Integer> colSet = new HashSet<>();
        Set<Integer> xyDiffSet = new HashSet<>();
        Set<Integer> xyAddSet = new HashSet<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        List<List<String>> result = new ArrayList<>();
        dfs(0, n, colSet, queens, xyDiffSet, xyAddSet, result);
        return result;
    }

    private void dfs(int row, int n, Set<Integer> colSet, int[] queens,
                     Set<Integer> xyDiffSet, Set<Integer> xyAddSet, List<List<String>> result) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            result.add(board);
            return;
        }
        for (int i = 0; i < n; i ++) {
            if (colSet.contains(i)) {
                continue;
            }
            if (xyAddSet.contains(row + i)) {
                continue;
            }
            if (xyDiffSet.contains(row - i)) {
                continue;
            }
            queens[row] = i;
            colSet.add(i);
            xyAddSet.add(row + i);
            xyDiffSet.add(row - i);
            dfs(row + 1, n, colSet, queens, xyDiffSet, xyAddSet, result);
            queens[row] = -1;
            colSet.remove(i);
            xyAddSet.remove(row + i);
            xyDiffSet.remove(row - i);
        }
    }

    private List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    public static void main(String[] args) {
        SolveNQueens s = new SolveNQueens();
        List<List<String>> lists = s.solveNQueens(5);
        for (List<String> item : lists) {
            for (String i : item) {
                System.out.println(i);
            }
            System.out.println("----------------------");
        }
    }
}

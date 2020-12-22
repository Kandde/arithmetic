package times_1.preordertraversal;

import times_1.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhaohongxin
 */
public class PreorderTraversal_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        recursion(result, root);
        return result;
    }

    private void recursion(List<Integer> result, TreeNode node) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        recursion(result, node.left);
        recursion(result, node.right);
    }
}


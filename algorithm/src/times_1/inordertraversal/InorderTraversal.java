package times_1.inordertraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaohongxin
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }
    public void traversal(TreeNode node, List<Integer> result) {
        if (null == node) {
            return;
        }
        if (null != node.left) {
            traversal(node.left, result);
        }
        result.add(node.val);
        if (null != node.right) {
            traversal(node.right, result);
        }
    }

}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
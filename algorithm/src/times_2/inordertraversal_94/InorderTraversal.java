package times_2.inordertraversal_94;


import java.util.LinkedList;
import java.util.List;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        recursion(result, root);
        return result;
    }

    private void recursion(List<Integer> result, TreeNode node) {
        if (node == null) {
            return;
        }
        recursion(result, node.left);
        result.add(node.val);
        recursion(result, node.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
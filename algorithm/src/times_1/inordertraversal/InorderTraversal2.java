package times_1.inordertraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhaohongxin
 */
public class InorderTraversal2 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

}


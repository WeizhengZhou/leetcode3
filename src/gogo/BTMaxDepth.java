package gogo;

public class BTMaxDepth {
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

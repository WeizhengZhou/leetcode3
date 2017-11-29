package gogo;

public class HouseRobberIII {
    public int rob(TreeNode root) {
        if (root==null) return 0;
        return Math.max(hasNode(root), noNode(root));
    }
    private int hasNode(TreeNode node) {
    	if (node==null) return 0;
    	return node.val+noNode(node.left)+noNode(node.right);
    }
    
    private int noNode(TreeNode node) {
    	if (node==null) return 0;
    	return Math.max(noNode(node.left), hasNode(node.left)) + Math.max(noNode(node.right), hasNode(node.right));
    }
}

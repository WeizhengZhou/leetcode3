package gogo;

public class CompleteTreeNode {
    public int countNodes(TreeNode root) {
        if (root==null) return 0;
        int leftH=height(root.left);
        int rightH=height(root.right);
        if (leftH==rightH) {
        	return (1<<leftH) + countNodes(root.right);
        } else {
        	return countNodes(root.left) + (1<<rightH);
        }
    }
    
    private int height(TreeNode node) {
    	if(node==null) return 0;
    	if (node.left==null) return 1;
    	return height(node.left)+1;
    }
}

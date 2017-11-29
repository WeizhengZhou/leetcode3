package gogo;

public class LCAOfBT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null || root==p||root==q) return root;
        if (p==q) return p;
        if (contains(p,q)) return p;
        if (contains(q,p)) return q;
        if (contains(root.left,p) && contains(root.right,q) || contains(root.left,q) && contains(root.right,p)) return root;
        if (contains(root.left,p) && contains(root.left,q)) return lowestCommonAncestor(root.left,p,q); 
        if (contains(root.right,p) && contains(root.right,q)) return lowestCommonAncestor(root.right,p,q);
        return null;
    }
    private boolean contains(TreeNode root, TreeNode p) {
    	if (root==p) return true;
    	if (root==null) return false;
    	return contains(root.left,p) || contains(root.right,p);
    }
}

package gogo;

public class LowestCommonAncester {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null || root==p||root==q) return root;
        if (p==q) return p;
        TreeNode small=p.val<q.val?p:q;
        TreeNode large=p.val>=q.val?p:q;
        if (small.val<root.val && large.val>root.val) return root;
        if (large.val<root.val) return lowestCommonAncestor(root.left,p,q); 
        if (small.val>root.val) return lowestCommonAncestor(root.right,p,q);
        return null;
    }
}

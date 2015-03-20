package xx;

public class ConvertSortedArray2BST {
	public TreeNode sortedArrayToBST(int[] num) {
        if(num==null || num.length==0)return null;
        return helper(0,num.length-1,num);
	}
	private TreeNode helper(int l,int r,int[] A){
	    if(l>r){return null;}
	    if(l==r){return new TreeNode(A[l]);}
	    int m=l+(r-l)/2;
	    TreeNode root=new TreeNode(A[m]);
	    root.left=helper(l,m-1,A);
	    root.right=helper(m+1,r,A);
	    return root;
	}
}

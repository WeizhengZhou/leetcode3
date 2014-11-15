package dp;

public class ArrayToBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public TreeNode sortedArrayToBST(int[] num) {
        if (num==null){
        	return null;
        }
        return helper(num,0,num.length-1);
    }
    
    public TreeNode helper(int[] A, int l, int r){
    	if(l>r){
    		return null;
    	}
    	if(l==r){
    		return new TreeNode(A[l]);
    	}
    	int m=l+(r-l)/2;
    	TreeNode root=new TreeNode(A[m]);
    	root.left=helper(A,l,m-1);
    	root.right=helper(A,m+1,r);
    	return root;
    }
}

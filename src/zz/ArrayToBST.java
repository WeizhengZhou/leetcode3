package zz;
//zz Reviewed
public class ArrayToBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public TreeNode sortedArrayToBST(int[] num) {
		if (num==null || num.length==0){
			return null;
		}
		return helper(0,num.length-1,num);
	}
	
	public TreeNode helper(int l, int r, int[] num){
		if(l>r){
			return null;
		}
		if(l==r){
			return new TreeNode(num[l]);
		}
		int m=l+(r-l)/2;
		TreeNode root=new TreeNode(num[m]);
		root.left=helper(l,m-1,num);
		root.right=helper(m+1,r,num);
		return root;
	}
}

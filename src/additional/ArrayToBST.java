package additional;

public class ArrayToBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayToBST a=new ArrayToBST();
		TreeNode t=a.arrayToBST(new int[]{1,2,3,4,5,6});
		TreeNode.printTree(t);
	}
	
	public TreeNode arrayToBST(int[] A){
		return build(0,A.length-1,A);
	}
	public TreeNode build(int l, int r, int[] A){
		if(l>r){
			return null;
		}
		if(l==r){
			return new TreeNode(A[l]);
		}
		int m=l+(r-l)/2;
		TreeNode root=new TreeNode(A[m]);
		root.left=build(l,m-1,A);
		root.right=build(m+1,r,A);
		return root;
	}

}

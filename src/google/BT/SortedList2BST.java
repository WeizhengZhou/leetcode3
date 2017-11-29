//package BT;
//
//
//public class SortedList2BST implements toBST{
//
//	@Override
//	public TreeNode toBST(ListNode head) {
//		
//		
//	}
//
//	@Override
//	public TreeNode toBST(int[] A) {
//		return toBST_helper(A,0,A.length-1);
//	}
//	private TreeNode toBST_helper(int[] A, int l, int r){
//		if(l>r) return null;
//		int m = l + (r-l)/2;
//		TreeNode root = new TreeNode(A[m]);
//		root.left = toBST_helper(A,l,m-1);
//		root.right = toBST_helper(A,m+1,r);
//		return root;
//	}
//	public static void main(String[] args){
//		SortedList2BST solu = new SortedList2BST(); 
//		int[] A = new int[]{1,2,3,4,5};
//		TreeNode root = solu.toBST(A);
//		System.out.println(root);
//	}
//}
//
//
//class ListNode{
//	int val;
//	ListNode next = null;
//	public ListNode(int val){
//		this.val = val;
//	}
//}
//
//interface toBST{
//	TreeNode toBST(ListNode head);
//	TreeNode toBST(int[] A);
//}
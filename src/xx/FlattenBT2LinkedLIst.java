package xx;

public class FlattenBT2LinkedLIst {
	 private class Pair{
		    TreeNode head;
		    TreeNode tail;
		    Pair(TreeNode n1,TreeNode n2){head=n1;tail=n2;}
		}
			public void flatten(TreeNode root) {
			    if(root==null){return;}
			    helper(root);
			}
			private Pair helper(TreeNode root){
			    if(root==null){return null;}
			    if(root.left==null && root.right==null)return new Pair(root,root);
			    Pair left=helper(root.left);
			    Pair right=helper(root.right);
			    if(left==null){
			        root.right=right.head;
			        return new Pair(root,right.tail);
			    }
			    else{
			        root.left=null;
			        root.right=left.head;
			        if(right==null){return new Pair(root,left.tail);}
			        left.tail.right=right.head;
			        return new Pair(root,right.tail);
			    }
			}
}

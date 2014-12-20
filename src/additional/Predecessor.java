package additional;

public class Predecessor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode rt=new TreeNode(5);
		TreeNode l1=new TreeNode(3);
		l1.parent=rt;
		rt.left=l1;
		TreeNode l2=new TreeNode(4);
		l2.parent=l1;
		l1.right=l2;
		TreeNode r1=new TreeNode(8);
		r1.parent=rt;
		rt.right=r1;
		TreeNode r2=new TreeNode(10);
		r2.parent=r1;
		r1.right=r2;
		TreeNode.printTree(rt);
		TreeNode pre=Predecessor.findSuc(10, rt);
		System.out.println("");
		if(pre!=null){
			System.out.println(pre.value);
		}
		else{
			System.out.println("null");
		}

	}
	
	public static TreeNode findPre(int v, TreeNode root){
		TreeNode n=find(v,root);
		if(n==null){
			return null;
		}
		TreeNode pre=null;
		if(n.left!=null){
			pre=n.left;
			while(pre.right!=null){
				pre=pre.right;
			}
			return pre;
		}
		TreeNode parent=n.parent;
		while(parent!=null && n!=parent.right){
			n=parent;
			parent=parent.parent;
		}
		return parent;
	}
	
	public static TreeNode findSuc(int v, TreeNode root){
		TreeNode n=find(v,root);
		if(n==null){
			return null;
		}
		TreeNode suc=null;
		if(n.right!=null){
			suc=n.right;
			while(suc.left!=null){
				suc=suc.left;
			}
			return suc;
		}
		TreeNode parent=n.parent;
		while(parent!=null && n!=parent.left){
			n=parent;
			parent=parent.parent;
		}
		return parent;
	}

	public static TreeNode find(int v,TreeNode root){
		if(root==null){
			return null;
		}
		if(v==root.value){
			return root;
		}
		if(v<root.value){
			return find(v,root.left);
		}
		else{
			return find(v,root.right);
		}
	}
}

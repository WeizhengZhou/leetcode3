package xx;

import java.util.*;

public class PopulateNextTreeNodeII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeLinkNode root=new TreeLinkNode(1);
		root.left=new TreeLinkNode(2);
		PopulateNextTreeNodeII p=new PopulateNextTreeNodeII();
		//p.connect(root);
		//System.out.println("1".compareTo()>0);
		//List<TreeLinkNode>[][] trees=new LinkedList[10][10];
		int[] A=new int[10];
	}
	private class Pair{
		TreeLinkNode parent;
		TreeLinkNode child;
		public Pair(TreeLinkNode p,TreeLinkNode c){
		parent=p;
		child=c;
	}
	public Pair(){
		parent=null;
		child=null;
	}
	}

	public void connect(TreeLinkNode root) {
		if(root==null){return;}
		root.next=null;
		TreeLinkNode cur=root;
		TreeLinkNode nextStart=findNextChild(root,true).child;
		if(nextStart==null) return;
		TreeLinkNode  child=nextStart;
		while(cur!=null){
			Pair nextPair=null;
			if(child==cur.left){
				System.out.println("child="+child.val);
				nextPair=findNextChild(cur,false);
			}
			else{
				nextPair=findNextChild(cur.next,true);
	}
			System.out.println("child="+child.val);
			System.out.println(nextPair.parent.val);
			System.out.println(nextPair.child==null);
	child.next=nextPair.child;
			cur=nextPair.parent;
	child=child.next;
		if(cur==null||child==null){
		cur=nextStart;
		nextStart=findNextChild(cur,true).child;
		if(nextStart==null){return;}
		else{
		child=nextStart;
	}
	}
	}
	}

	private Pair findNextChild(TreeLinkNode cur, boolean isLeft){
		Pair res=new Pair();
		
		if(cur==null){return res;}
		System.out.println("cur="+cur.val);
		res.parent=cur;
		TreeLinkNode child=isLeft?cur.left:cur.right;
		if(child!=null){
			
			res.parent=cur;
			res.child=child;
			return res;
			}
		while(cur!=null){
			if(isLeft){
				System.out.println("isLeft...");
				child=cur.right;
			}
			else{
				cur=cur.next;
				if(cur==null){
					break;
				}
				else{	child=cur.left;	}
			}
			if(child!=null){
				res.parent=cur;
				res.child=child;
				return res;
			}
			isLeft=!isLeft;
		}
		return res;
	}

}

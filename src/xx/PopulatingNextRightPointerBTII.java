package xx;

public class PopulatingNextRightPointerBTII {
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
				nextPair=findNextChild(cur,false);
			}
			else{
				nextPair=findNextChild(cur.next,true);
			}
			child.next=nextPair.child;
			cur=nextPair.parent;
			child=child.next;
			if(cur==null){
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
		//res.parent=cur;
		TreeLinkNode child=isLeft?cur.left:cur.right;
		if(child!=null){
			res.parent=cur;
			res.child=child;
			return res;
		}
		while(cur!=null){
			if(isLeft){
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

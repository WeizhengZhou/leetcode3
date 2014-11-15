package dp;

public class NextRIghtNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void Connect(TreeLinkNode root){
		if(root==null){
			return;
		}
		root.next=null;
		TreeLinkNode next=root.left;
		while(next!=null){
			TreeLinkNode cur=next;
			
		}
	}

}

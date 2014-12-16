package bt;

import java.util.Stack;

public class InorderTwoBST {
	public void inorder(TreeNode r1, TreeNode r2){
		
		TreeNode p1 = r1;
		TreeNode p2 = r2;
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		while(p1 != null || !s1.isEmpty() || p2 != null || !s2.isEmpty()){
			if(p1 != null){
				s1.push(p1);
				p1 = p1.left;
			}			
			else if(p2 != null){
				s2.push(p2);
				p2 = p2.left;
			}
			else if(p1 == null && p2 == null){
				if(s1.isEmpty())
					System.out.println(s2.pop().val);
				else if(s2.isEmpty())
					System.out.println(s1.pop().val);
				else if(s1.peek().val < s2.peek().val){					
					System.out.print(s1.peek().val+", ");
					p1 = s1.pop().right;
					
				}
				else{
					System.out.print(s2.peek().val+", ");
					p2 = s2.pop().right;
				}
			}			
		}		
	}
	public static void main(String[] args){
		TreeNode r1 = new TreeNode(4);
		r1.left = new TreeNode(2);
		r1.right = new TreeNode(7);
		
		TreeNode r2 = new TreeNode(5);
		r2.left = new TreeNode(1);
		r2.right = new TreeNode(9);
		
		InorderTwoBST solu = new InorderTwoBST();
		solu.inorder(r1, r2);	
	}

}

package bt;
import java.util.*;
public class TwoSumBST{
	public void twoSum(TreeNode root, int target){
		if(root == null) return;
		TreeNode p1 = root;
		TreeNode p2 = root;
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		while((p1 != null || !s1.isEmpty()) && (p2 != null || !s2.isEmpty())){
			if(p1 != null){
				s1.push(p1);
				p1 = p1.left;
			}
			if(p2 != null){
				s2.push(p2);
				p2 = p2.right;
			}			
			if(p1 == null && p2 == null){
				p1 = s1.pop();
				p2 = s2.pop();
				int value = p1.val+p2.val;
				if(value == target){
					System.out.println("p1 = " + p1.val + ", p2 = " + p2.val);
					return;
				} 
				else if(value < target) 
					p1 = p1.right;
				else					
					p2 = p2.left;
			}				
		}
	}
	public static void main(String[] args){
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(8);
		int target = 14;
		TwoSumBST solu = new TwoSumBST();
		solu.twoSum(root, target);
		
	}
}

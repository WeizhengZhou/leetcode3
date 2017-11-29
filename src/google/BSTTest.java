import java.util.*;

import BT.TreeNode;
public class BSTTest {
	public TreeNode closet(TreeNode root, int key){
		if(root == null) return root;
		if(root.val == key) return root;
		else if(key < root.val){
			TreeNode left = closet(root.left,key);
			if(left != null && Math.abs(left.val - key) < Math.abs(root.val - key)){
				return left;
			}
			else
				return root;
		}
		else{
			TreeNode right = closet(root.right,key);
			if(right != null && Math.abs(right.val - key) < Math.abs(root.val - key)){
				return right;
			}
			else
				return root;
		}
	}
	public TreeNode min(TreeNode root){
		if(root == null || root.left == null) return root;
		TreeNode cur = root;
		while(cur.left != null){
			cur = cur.left;
		}
		return cur;
	}
	public TreeNode successor(TreeNode root, TreeNode node){
		if(node == null) return null;
		if(node.right != null) return min(node.right);
		else{
			TreeNode cur = root;
			TreeNode succ = null;
			while(cur != null){
				if(cur == node) break;
				else if(node.val < cur.val){
					succ = cur;
					cur = cur.left;
				}
				else{
					cur = cur.right;
				}
			}
			return succ;
		}
	}
	public List<TreeNode> kCloset(TreeNode root, int key){
		TreeNode center = closet(root, key);
		List<TreeNode> list = new ArrayList<>();
		list.add(center);
		TreeNode r = successor(root,center);
		while(r != null){
			list.add(r);
			r = successor(root,r);
		}
		return list;
	}
	public TreeNode closet_Iter(TreeNode root, int key){
		TreeNode res = null;
		TreeNode cur = root;
		while(cur != null){
			if(key == cur.val)
				return cur;
			else if(key < cur.val){
				res = cur;
				cur = cur.left;
			}
			else{
				res = cur;
				cur = cur.right;
			}
		}
		return res;
	}
	public static void main(String[] args){
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(5);
		BSTTest solu = new BSTTest();
//		TreeNode min = solu.min(root);
//		System.out.println(min);
//		System.out.println(solu.successor(root, min));
//		System.out.println(solu.successor(root, root));
//		List<TreeNode> list = solu.kCloset(root, 4);
//		System.out.println(list);
//		list.toArray();
		System.out.println(solu.closet_Iter(root, 10));
		Arrays.copyOfRange(original, from, to)
		
		
	}
	
}


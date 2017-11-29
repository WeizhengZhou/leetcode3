package gogo;

import java.util.LinkedList;
import java.util.List;

public class CountSmaller {
	public static void main(String[] args) {
		CountSmaller c=new CountSmaller();
		c.countSmaller(new int[] {5,2,6,1});
	}
	class TreeNode {
		int val;
		int sum;
		int dup;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val=x;
		}
	}
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list=new LinkedList<> ();
        if(nums==null || nums.length==0) return list;
        TreeNode root=new TreeNode(nums[nums.length-1]);
        for (int i=nums.length-1;i>=0;i--) {
        	add(0, nums[i],root,list);
        }
        return list;
    }
    
    private void add(int pre, int x, TreeNode root, List<Integer> list) {
    	System.out.println("pre="+pre+", x="+x+", root="+root.val);
    	if (root==null) {
    		list.add(0,pre);
    		return;
    	}
    	if (x==root.val) {System.out.println("=="+pre+root.sum);
    		list.add(0,pre+root.sum);
    		root.dup++;   		
    		return;
    	}
    	if (x<root.val) {System.out.println("<");
    		if (root.left==null) {
    			TreeNode node=new TreeNode(x);
    			root.left=node;
    		}
    		root.sum++;
    		add(pre,x,root.left,list);
    	}
    	if (x>root.val) {System.out.println("> root.sum="+root.sum+",root.dup="+root.dup);
    		if (root.right==null) {
    			TreeNode node=new TreeNode(x);
    			root.right=node;
    		}
    		add(pre+root.sum+root.dup,x,root.right,list);
    	}
    }
}

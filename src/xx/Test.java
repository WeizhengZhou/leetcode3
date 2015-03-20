package xx;

import java.util.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t=new Test();
		System.out.println(Integer.MAX_VALUE);
		List<String> l=t.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
		for(String n:l){
			System.out.println(n);
		}
		System.out.println('9'-'1');

	}
	
	public List<String> findRepeatedDnaSequences(String s) {
        List<String> res=new LinkedList<>();
if(s==null || s.length()==0){return res;}
int DNASize=10;
Map<String,Integer> map=new HashMap<>();
for(int i=0;i<=s.length()-DNASize;i++){
	int j=i+DNASize;
	String substring=s.substring(i,j);
	if(map.containsKey(substring)){
	map.put(substring,map.get(substring)+1);
}
else{
	map.put(substring,1);
}
}
for(String key:map.keySet()){
	if(map.get(key)>1){ res.add(key); }
}        
return res;
    }
	
	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> res=new LinkedList<>();
		if(n<=0){return res;}
		List<TreeNode>[][] trees=new LinkedList[n][n];
		for(int i=0;i<n;i++){
			List<TreeNode> list=new LinkedList<>();
			list.add(new TreeNode(i+1));
			trees[i][i]=list;
			for(TreeNode node:trees[i][i]){
				System.out.println(node.val);
			}
		}
		for(int d=1;d<n;d++){
			for(int i=0;i<n-d;i++){
				int j=i+d;
				List<TreeNode> subTree=new LinkedList<>();
				for(int root=i;root<=j;root++){
					TreeNode rt=new TreeNode(root+1);
					List<TreeNode> emptyNode=new LinkedList<TreeNode>();
					emptyNode.add(null);
					List<TreeNode> left=root==i?emptyNode:trees[i][root-1];
					List<TreeNode> right=root==j?emptyNode:trees[root+1][j];
					for(TreeNode l:left){
						for(TreeNode r:right){
						rt.left=l;
						rt.right=r;
						subTree.add(rt);
						}
					}
				}
				trees[i][j]=subTree;
				for(TreeNode node:trees[i][j]){
					System.out.println(node.val);
				}
			}
		}
		return trees[0][n-1];
	}

}

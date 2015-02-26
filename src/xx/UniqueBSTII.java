package xx;
import java.util.*;
public class UniqueBSTII {
	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> res=new LinkedList<>();
		res.add(null);
		if(n<=0){return res;}
		List<TreeNode>[][] trees=new LinkedList[n][n];
		for(int i=0;i<n;i++){
			List<TreeNode> list=new LinkedList<>();
			list.add(new TreeNode(i+1));
			trees[i][i]=list;
		}
		for(int d=1;d<n;d++){
			for(int i=0;i<n-d;i++){
				int j=i+d;
				List<TreeNode> subTree=new LinkedList<>();
				for(int root=i;root<=j;root++){

					List<TreeNode> emptyNodeList=new LinkedList<>();
					emptyNodeList.add(null);
					List<TreeNode> left=root==i?emptyNodeList:trees[i][root-1];
					List<TreeNode> right=root==j?emptyNodeList:trees[root+1][j];
					for(TreeNode l:left){
						for(TreeNode r:right){
							TreeNode rt=new TreeNode(root+1);
							rt.left=l;
							rt.right=r;
							subTree.add(rt);
						}
					}
				}
				trees[i][j]=subTree;
			}
		}
		return trees[0][n-1];
	}
}

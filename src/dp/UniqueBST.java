package dp;

public class UniqueBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueBST u=new UniqueBST();
		System.out.println(u.uniqueBST(3));

	}
	
	public int uniqueBST(int n){
		/*
		 * check if n <0
		 */
		int [] tree=new int[n];//nTrees
		tree[0]=1;
		
		for(int i=1;i<n;i++){
			for(int node=0;node<=i;node++){//nNodesInLeftSubTree
				int l=node==0?1:tree[node-1];
				int r=i==node?1:tree[i-node-1];
				
				tree[i]+=l*r;
			}
		}
		return tree[n-1];
		
		
		/*
		 * int[] nTrees = new int[n+1];//nTrees[0] is the number of unique trees with 0 nodes
		 * nTrees[0] = 1;//null tree
		 * for(int i=1;i<=n;i++){
		 * 	  for(int j=0;j<i;j++){//j is the number of nodes in the left subtree, it can goes from 0 to i-1
		 * 		  nTree[i] = nTree[j] * nTree[i-j-1];
		 * 	  }
		 * }
		 * return nTrees[n];
		 */
	}

}

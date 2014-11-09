package dp;

public class UniqueBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueBST u=new UniqueBST();
		System.out.println(u.uniqueBST(3));

	}
	
	public int uniqueBST(int n){
		int [] tree=new int[n];
		tree[0]=1;
		for(int i=1;i<n;i++){
			for(int node=0;node<=i;node++){
				int l=node==0?1:tree[node-1];
				int r=i==node?1:tree[i-node-1];
				tree[i]+=l*r;
			}
		}
		return tree[n-1];
	}

}

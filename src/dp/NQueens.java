package dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueens n=new NQueens();
		List<String[]> r=n.nQueens(4);
		for(String[] a:r){
			System.out.println(Arrays.toString(a));
		}

	}
	
	public List<String[]> nQueens(int n){
		List<int[]> res=new LinkedList<int[]>();
		helper(0,n,res,new int[n]);		
		return buildString(res);
		//return res;
	}
	
	public void helper(int level, int N, List<int[]> res, int[] pre){
		if (level>=N){
			//System.out.println(Arrays.toString(pre));
			res.add(Arrays.copyOf(pre, N));
			return;
		}
		for(int i=0;i<N;i++){
			if(isValid(level,i,pre)){				
				pre[level]=i;
				//System.out.println(Arrays.toString(pre));
				helper(level+1,N,res,pre);
			}
		}
	}
	public boolean isValid(int l, int i, int[] pre){
		for(int j=0;j<l;j++){
			if(i==pre[j]){
				return false;
			}
			if(Math.abs(l-j)==Math.abs(pre[j]-i)){
				return false;
			}			
		}
		return true;
	}
	public List<String[]> buildString(List<int[]> res){
		
		List<String[]> R=new LinkedList<String[]>();
		for(int[] A:res){		
			String[] SA=new String[A.length];
			int index=0;
			for(int i=0;i<A.length;i++){
				int col=A[i];				
				StringBuilder sb=new StringBuilder();
				for(int j=0;j<col;j++){
					sb.append(".");
				}
				sb.append("Q");
				for(int j=col+1;j<A.length;j++){
					sb.append(".");
				}
				SA[index++]=sb.toString();
			}
			R.add(SA);
		}
		return R;
	}
}

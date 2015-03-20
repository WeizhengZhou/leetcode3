package xx;

public class MaxGap {
	private class Pair{
		int min;
		int max;
		public Pair(int x,int y){
			min=x;
			max=y;
		}
	}
	public int maximumGap(int[] num) {
		if(num==null || num.length<=1)return 0;
		double gap=0;
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		int n=num.length;
		for(int i=0;i<n;i++){
			min=Math.min(min,num[i]);
			max=Math.max(max,num[i]);
		}
		Pair[] A=new Pair[n];
		gap=(max-min)/(n-1.0);
		for(int i=0;i<n;i++){
			if(num[i]==min||num[i]==max)continue;
			int index=(int)((num[i]-min)/gap);
			if(A[index]==null){A[index]=new Pair(num[i],num[i]);}
			else{
				A[index].min=Math.min(A[index].min,num[i]);
				A[index].max=Math.max(A[index].max,num[i]);
			}
		}
		int last=min;
		int maxGap=0;
		for(int i=0;i<n;i++){
			if(A[i]!=null){
				maxGap=Math.max(maxGap,A[i].min-last);
				last=A[i].max;
			}
		}
		maxGap=Math.max(maxGap,max-last);
		return maxGap;
	}
}

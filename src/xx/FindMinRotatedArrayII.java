package xx;

public class FindMinRotatedArrayII {
	public int findMin(int[] num) {
		if(num==null || num.length==0){
			return 0;
		}
		return bsHelper(0,num.length-1,num);
	}
	private int bsHelper(int l, int r, int[] num){
		if(num[l]<num[r])return num[l];
		if(l==r) return num[l];
		if(l+1==r) return Math.min(num[l],num[r]);
		int m=l+(r-l)/2;
		if(num[m-1]>num[m]){return num[m];}
		else if(num[l]<num[m]){return bsHelper(m+1,r,num);}
		else if(num[l]>num[m]){return bsHelper(l,m-1,num);}
		else{return Math.min(bsHelper(l,m-1,num),bsHelper(m+1,r,num));}
	}
}

package zz;

public class MinSortA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinSortA m=new MinSortA();
		System.out.println(m.findMin(new int[]{4,5,6,1,2,3}));

	}
    public int findMin(int[] num) {
        if(num==null || num.length==0){
        	return 0;
        }
        return bs(0,num.length-1,num);
    }
    
    public int bs(int l, int r, int[] num){
    	//System.out.println(l+" "+r);
    	if(num[l]<num[r]){
        	return num[l];
        }
    	if(l==r){
    		return num[l];
    	}
    	if(l+1==r){
    		return Math.min(num[l], num[r]);    		
    	}
    	int m=l+(r-l)/2;
    	if(num[m]<num[m-1]){
    		return num[m];
    	}
    	if(num[m]<num[l]){
    		return bs(l,m-1,num);
    	}
    	return bs(m+1,r,num);
    }
}

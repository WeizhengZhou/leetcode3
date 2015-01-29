//zz reviewed
package zz;

public class Peak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Peak p=new Peak();
		System.out.println(p.findPeakElement(new int[]{1,2,2,3,2}));

	}
	
    public int findPeakElement(int[] num) {
        if(num==null|| num.length==1){
        	return 0;
        }
        
        return bs(0,num.length-1,num);
        
    }
	
//zz consider my solution below, maybe simpler
/*
    public int findPeakElement(int[] num) {
       if(num == null || num.length ==0) return -1;
       return helper(num,0,num.length-1);
    }
    private int helper(int[] num, int l, int r){
        if(l<0 || r>=num.length) return -1;
        if(l==r) return l;
        if(l+1==r) return num[l]>num[r]?l:r;
        int m = l+(r-l)/2;
        if(num[m] > num[m-1] && num[m] > num[m+1]) return m;
        else if(num[m+1] > num[m]) return helper(num,m+1,r);
        else return helper(num,l,m-1);
    }

*/    
    public int bs(int l,int r, int[] num){
    	//System.out.println("l="+l+",r="+r);
    	if(l>r){
    		return -1;
    	}
    	if(l==r){
    		return l;
    	}
	//zz these two cases can be handled genearally in l+1==r
    	if(l==0 && num[l]>num[l+1]){
    		return 0;
    	}
    	if(r==num.length-1 && num[r]>num[r-1]){
    		return r;
    	}
    	int m=l+(r-l)/2;//zz you check m-1 m+1 out-of-boundary, because you didn't check l+1==r before
    	if(m-1>=0 && num[m-1]<num[m] && m+1<num.length && num[m+1]<num[m]){
    		return m;
    	}
    	else if(m+1<num.length && num[m+1]>num[m]){
    		return bs(m+1,r,num);
    	}
    	else{
    		return bs(l,m-1,num);
    	}
    	
    }
}

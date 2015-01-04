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
    
    public int bs(int l,int r, int[] num){
    	//System.out.println("l="+l+",r="+r);
    	if(l>r){
    		return -1;
    	}
    	if(l==r){
    		return l;
    	}
    	if(l==0 && num[l]>num[l+1]){
    		return 0;
    	}
    	if(r==num.length-1 && num[r]>num[r-1]){
    		return r;
    	}
    	int m=l+(r-l)/2;
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

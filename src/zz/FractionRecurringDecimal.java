package zz;

public class FractionRecurringDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Double.toString(1.0/19.0));
		//System.out.println(1E-5);
		FractionRecurringDecimal f =new FractionRecurringDecimal();
		System.out.println(f.fractionToDecimal(1, 19));
	}
	
    public String fractionToDecimal(int numerator, int denominator) {
    	double ep=1E-25;
        double nu=numerator;
        double de=denominator;
        double res=nu/de;
        long i=1;
        long recur=0;
        //System.out.println(res*1E9);
        //System.out.println((int)(res*1E9));
        //System.out.println(res*1E9-(int)(res*1E9));
        if(Math.abs(res*1E15-(long)(res*1E15))<ep){
        	return Double.toString(res);
        }
        for( i=10;i<1E20;i*=10){ 
        	for(long j=1;j<i;j*=10){
	        	recur=(long)(res*i)-(long)(res*j);
	        	System.out.println("i="+i+",j="+j);
	        	System.out.println(recur);
	        	System.out.println(res*i);
	        	System.out.println(ep);
	        	System.out.println("diff="+Math.abs(res*i-res*j-recur));
	        	System.out.println();
	        	if (Math.abs(res*i-res*j-recur)<ep){
	        	    recur=(long)(res*i);
	        	    System.out.println("i="+i+",j="+j);
	        	    //System.out.println((int)(res*j));
	        	    //System.out.println(recur-(int)(res*j)*i/j);
	        	    if(j-1<ep)	        	          
	        	    {
	        	    	if(i>10 && recur*10/i==0){
	        	    		StringBuilder sb=new StringBuilder();
	        	    		long k=i;
	        	    		while(recur*10/k==0){
	        	    			sb.append('0');
	        	    			k/=10;
	        	    		}
	        	    		return "0.("+sb.toString()+recur+")";
	        	    	}
	        	    	else{
	        	    		return "0.("+recur+")";
	        	    	}	        	    	
	        	    }
	        	    else{
	        	    	recur=(long)(recur-(long)(res*j)*i/j);
	        	    	return "0."+(long)(res*j)+"("+recur+")";
	        	    }
	        	}
        	}
        }
        return Double.toString(res);       
    }

}

//zz reviewed
//zz iterative solution needed

package zz;

public class PowN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public double pow(double x, int n) {
		 if(n==0){
			 return 1;
		 }
		 if(n==1){
			 return x;
		 }
		 double p=helper(x,n);
		 if(n<0){
			 return 1/p;
		 }
		 return p;
	 }
	 
	 public double helper(double x, int n){
		 n=Math.abs(n);
		 if(n==0){
			 return 1;
		 }
		 if(n==1){
			 return x;
		 }
		 double square=helper(x,n/2);
		 if(n%2==1){
			 return square*square*x;
		 }
		 else{
			return square*square; 
		 }
	 }
	/*
        public double pow(double x, int n){
            if(n == 0) return 1;//x^0 = 1
            if(x == 0) return 0;//0^n = 0
	    double[] xpow2i = new double[32];
            xpow2i[0] = x;
            for(int i=1;i<32;i++){
	       xpow2i[i] = xpow2i[i-1]*xpow2i[i-1];
            }
            if(n==Integer.MIN_VALUE) 
			return xpow2i[31];
            int m = Math.abs(n);
            double res = 1;
            int count = 0;
            for(int i=0;i<31;i++){
		if((m & 1<<i) != 0)
            	    res *= xpow2i[i];
		} 
            return (n>0)?res:1/res;
	}

       */

}

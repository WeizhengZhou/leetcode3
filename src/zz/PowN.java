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

}

package zz;

public class Sqrt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public int sqrt(int x) {
		 if(x==0){
			 return 0;
		 }
		 if(x==1){
			 return 1;
		 }
		 return bs(1,x,x);
	 }
	 
	 public int bs(int l, int r, int x){
		 if(l>r){
			 return -1;
		 }
		 if(l==r){
			 return l;
		 }
		 int m=l+(r-l)/2;
		 if(m<=x/m && (m+1)>x/(m+1)){
			 return m;
		 }
		 if(m>x/m){
			 return bs(l,m-1,x);
		 }
		 else{
			 return bs(m+1,r,x);
		 }
	 }
}

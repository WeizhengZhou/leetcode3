package xx;

public class SqrtX {
	public int sqrt(int x) {
		 if(x==0){return 0;}
		 return bsHelper(0,x,x);
	 }
	 private int bsHelper(int l,int r, int x){
	     if(l==r){return l;}
	     if(l+1==r){
	         if(r*r>x){return l;}
	         else{return r;}
	     }
	     int m=l+(r-l)/2;
	     if(m<=x/m && (m+1)>x/(m+1)){return m;}
	     else if(m<x/m){return bsHelper(m+1,r,x);}
	     else{return bsHelper(l,m-1,x);}
	 }
}

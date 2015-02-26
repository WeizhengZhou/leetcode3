package xx;

public class PowerXN {
	public double pow(double x, int n) {
		if(n==0){return 1;}
		if(n==1){return x;}
		if(x==0){return 0;}
		boolean isPo=n>0?true:false;
		int absN=Math.abs(n);
		double half=pow(x,absN/2);
		double res=0;
		if(absN%2==1){
		    res=half*half*x;
		}
		else{res=half*half;}
		return isPo?res:1/res;
	 }
}

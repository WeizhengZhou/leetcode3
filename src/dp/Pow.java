package dp;

public class Pow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public double pow(double x, int n) {
    	int nn=n;
    	n=Math.abs(n);
    	double res=0;
        if(n==0){
        	return 1;
        }
        if(x==0){
        	return 0;
        }
        double s=pow(x,n/2);
        
        if(n%2==1){
        	res= s*s*x;
        }
        else{
        	res= s*s;
        }
        return nn>0?res:1/res;
    }
}

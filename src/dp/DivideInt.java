package dp;

public class DivideInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DivideInt d= new DivideInt();
		System.out.println(d.divide( -2147483648,1));
		//System.out.println(Integer.MIN_VALUE+1);

	}
    public int divide(int dividend, int divisor) {
        if(dividend==0 || divisor==0){
        	return 0;
        }
        boolean isPo=(dividend>0 && divisor>0)||(dividend<0 && divisor<0)?true:false;
        int a=(dividend>0)?-dividend:dividend;
        int b=(divisor>0)?-divisor:divisor;
        if(a>b){
        	return 0;
        }
        int s=a;
        int x=b;
        int c=1;
        while((s-x)<=x){
        	System.out.println(x+",s-x="+(s-x)+",s-x-x="+(s-x-x));
        	//System.out.println();
        	if(x==Integer.MIN_VALUE){
        		break;
        	}
        	x=x+x; 
        	c=c+c;
        }
        int res=c+divide(a-x,b);
        return isPo?res:-res;
    }
}

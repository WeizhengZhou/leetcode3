package dp;

public class ReverseInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int reverse(int x) {
        if(x==0){
        	return 0;
        }
        boolean isPo=x>0?true:false;
        int s=Math.abs(x);
        int res=0;
        while(s!=0){
        	int digit=s%10;
        	if(isPo && res>(Integer.MAX_VALUE-digit)/10){
        		return 0;
        	}
        	if(!isPo && -res<(Integer.MIN_VALUE+digit)/10){
        		return 0;
        	}
        	res=res*10+digit;
        	s=s/10;
        }
        return isPo?res:-res;
        
    }
}

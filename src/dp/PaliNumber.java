package dp;

public class PaliNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isPalindrome(int x) {
        if(x==0){
        	return true;
        }
        if(x<0){
        	return false;
        }
        int s=Math.abs(x);
        int r=1;
        while(s/r/10!=0){
        	r*=10;
        }       
        int d=10;
        while(s!=0 && r>=d){
        	int first=s/r;
        	int last=s%d;
        	if(first!=last){
        		return false;
        	}
        	s=s%r;
        	s=s/d;
        	r/=100;
        }
        return true;
    }
}

package xx;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
        if(x<0){return false;}
        int divisor=1;
        while(x/divisor/10>0){
            divisor*=10;
        }
        int n=x;
        while(divisor>=10 && n>0){
            int top=n/divisor;
            int last=n%10;
            if(top!=last){return false;}
            n=n%divisor;
            n=n/10;
            divisor=divisor/100;
        }
        return true;
    }
}

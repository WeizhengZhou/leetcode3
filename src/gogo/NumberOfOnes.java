package gogo;

public class NumberOfOnes {
	public static void main(String[] args) {
		NumberOfOnes n = new NumberOfOnes();
		System.out.println(n.countDigitOne(110));
	}
    public int countDigitOne(int n) {
    	if (n<=0) return 0;
        String s=String.valueOf(n);
        char[] ca=s.toCharArray();
        int sum=0;
        int digit=1;
        int right=0;
        for (int i=s.length()-1;i>0;i--) {
        	int c=ca[i]-'0';
        	right=c*digit+right;
        	if (c!=1) {  		
        		sum+=(n/10/digit)*digit;
                if (c>1) sum+=digit;
        	} else if (c==1) {
        		sum+=n/10/digit*digit+right-digit+1;
        	}
        	digit=digit*10;
        }
        if (ca[0]-'0'>1) {
        	sum+=digit;
        } else if (ca[0]-'0'==1) {
        	sum+=n-digit+1;
        }    
        return sum;
    }
}
//13=2+4
// 1,10-19 =1+10+1
// 110 =11+11+
//1,10-19,21,31,...,91 = 11+11+11


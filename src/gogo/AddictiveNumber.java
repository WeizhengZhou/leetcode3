package gogo;

public class AddictiveNumber {
    public boolean isAdditiveNumber(String num) {
        if (num==null || num.length()<3) return false;
        for(int i = 0;i<=(num.length()/2);i++) { 
            //i=3,j=4;
        	for (int j=i+1;j <= num.length()-i-1;j++) {
        		if (helper(0,i,j,num)) return true;
        	}
        }
        return false;
    }
    private boolean helper(int first, int firstEnd, int secondEnd, String num) {System.out.println("firstEnd="+firstEnd);
        if (num.charAt(first)=='0' && first!=firstEnd || num.charAt(firstEnd+1)=='0' && firstEnd+1!=secondEnd) return false;
        if (first!=0 && secondEnd==num.length()-1) return true;
    	long firstNum=Long.valueOf(num.substring(first,firstEnd+1)); System.out.println("first="+firstNum);
    	long secondNum=Long.valueOf(num.substring(firstEnd+1,secondEnd+1)); System.out.println("second="+secondNum);
    	for (int i=secondEnd+1;i<num.length();i++) {
    		long sum=Long.valueOf(num.substring(secondEnd+1,i+1));System.out.println("sum="+sum);
    		if (firstNum+secondNum==sum) {
    			if (helper(firstEnd+1,secondEnd,i,num)) return true;
    		}
    	}System.out.println("return false");
    	return false;
    }
}

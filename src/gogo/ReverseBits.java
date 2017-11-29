package gogo;

public class ReverseBits {
	public static void main (String[] args) {
		//Integer n=  4294967295;
		System.out.println(1^-1);
	}
	// need Java 8
    public int reverseBits(int n) {
        if (n==0) return 0;
        Integer num = n;
        for (int i=0;i<16;i++) {
        	Integer low = (num & (1<<i))>>i;
        	Integer high = (num& (1<<(31-i)))>>(31-i);
            high=high<0?-high:high;
        	if (low!=high) {
        		num = num^(1<<i);
        		num=num^(1<<(31-i));
        	}
        }
        return num;
    }
}

package gogo;

public class NumberOfOne {
	public static void main(String[] args){
		//Integer n =   2147483648;
	}
    public int hammingWeightFail(int n) {
        if (n==0) return n;
        Integer m=n;
        int count=0;
        while(m!=0) {
        	if ((m&1) !=0) count++;
        	m=m>>1;
        }
        return count;
        //correct:
    }
    
    public int hammingWeight(int n) {
        if (n==0) return n;
        Integer m=n;
        int count=0;
        int mask=1;
        for(int i=0;i<32;i++) {
            if((m&mask) != 0) count++;
            mask=mask<<1;
        }
        return count;
    }
}

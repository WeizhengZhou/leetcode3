package gogo;

public class BitwiseAnd {
	public static void main(String[] args) {
		System.out.println(1>>1);
	}
    public int rangeBitwiseAnd(int m, int n) {
    	if (m==0) return 0;
        int sum=m;
        int tmp=m;
        int count=0;
        while(tmp>0){
        	tmp=tmp>>1;
        	count++;
        }
        for(int i=m;i<=(1<<(count)-1);i++){
        	sum=sum&i;
        }
        return sum;
    }
}

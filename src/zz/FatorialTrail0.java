package zz;

public class FatorialTrail0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FatorialTrail0 f=new FatorialTrail0();
		System.out.println(f.trailingZeroes(1808548329));
		//System.out.println(Integer.MAX_VALUE);

	}
    public int trailingZeroes(int n) {
        int count=0;
        for(long i=5;n/i>0;i=i*5){
        	count+=n/i;
        	System.out.println("i="+i);
        }
        return count;
    }
}

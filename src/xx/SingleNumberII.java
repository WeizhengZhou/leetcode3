package xx;

public class SingleNumberII {
	 public int singleNumber(int[] A) {
			if(A==null || A.length==0){return 0;}
			int ones=0;
			int twos=0;
			for(int i=0;i<A.length;i++){
				int carry=ones&A[i];
				ones=ones^A[i];
				twos=carry|twos;
				int mask=ones&twos;
				ones=mask^ones;
				twos=mask^twos;
		}
		return ones;

		    }
}

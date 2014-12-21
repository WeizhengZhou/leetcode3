package additional;

public class TripletSeq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TripletSeq t=new TripletSeq();
		System.out.println(t.findTriplet(new int[]{8,25,193,600}));

	}
	
	public boolean findTriplet(int[] A){
		int[] leftLarge=new int[A.length];
		int[] rightSmall=new int[A.length];
		leftLarge[0]=Integer.MIN_VALUE;
		int max=Integer.MIN_VALUE;
		for(int i=1;i<A.length;i++){
			max=Math.max(max, A[i-1]);
			leftLarge[i]=max;
		}
		int min=Integer.MAX_VALUE;
		rightSmall[A.length-1]=min;
		for(int i=A.length-2;i>=0;i--){
			min=Math.min(min, A[i+1]);
			rightSmall[i]=min;
			if (A[i]>rightSmall[i] && A[i]<leftLarge[i]){
				return true;
			}
		}
		return false;
	}

}

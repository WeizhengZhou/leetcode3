package additional;

public class Majority {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Majority m=new Majority();
		System.out.println(m.getMajority(new int[]{1,2,2,2,3,3,3,3,3}));

	}
	
	public int getMajority(int[] A){
		if(A==null || A.length==0){
			return -1;
		}
		int count=0;
		int cur=0;
		for(int i=0;i<A.length;i++){
			if(count==0){
				cur=A[i];
				count++;
			}
			else{
				if(A[i]==cur){
					count++;
				}
				else{
					count--;
				}
			}
		}
		count=0;
		for(int i=0;i<A.length;i++){
			if(A[i]==cur){
				count++;
			}
		}
		if(count>A.length/2){
			return cur;
		}
		else{
			return -1;
		}
	}

}

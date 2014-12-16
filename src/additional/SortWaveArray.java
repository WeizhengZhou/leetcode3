package additional;

public class SortWaveArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortWaveArray s=new SortWaveArray();
		System.out.println(s.SortWave("1234"));

	}
	
	public String SortWave(String S){
		char[] A=S.toCharArray();
		for(int i=0; i<S.length()-1; i++){
			if(i%2==0){
				if(A[i]>A[i+1]){
					char t=A[i];
					A[i]=A[i+1];
					A[i+1]=t;
				}
			}
			else{
				if(A[i]<A[i+1]){
					char t=A[i];
					A[i]=A[i+1];
					A[i+1]=t;
				}
			}
		}
		return new String(A);
	}

}

package additional;

import java.util.Arrays;
import java.util.Map;

public class CutLog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int getMaxPrice(Map<Integer,Integer> map, int N){
		int[] max=new int[N+1];
		int[] length=new int[map.size()];
		int j=0;
		for(int l:map.keySet()){
			length[j]=l;
			j++;
		}
		Arrays.sort(length);
		max[0]=0;
		for(int i=1;i<=N;i++){
			int k=0;
			int m=0;
			//int l=0;
			while(k<length.length && length[k]<=i){
				m=Math.max(m, map.get(length[k])+max[i-length[i-length[k]]]);
				k++;
			}
			max[i]=m;
		}
		return max[N];
	}

}

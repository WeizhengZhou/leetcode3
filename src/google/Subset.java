import java.util.*;
public class Subset {
	public void subset(int[] A){
		Arrays.sort(A);
		subset_helper(A, 0, new ArrayList<Integer>());
	}
	private void subset_helper(int[] A, int index, List<Integer> list){
		if(index >= A.length){
			System.out.println(list);
			return;
		}	
		int end = index;
		int count = 0;
		while(end<A.length && A[end] == A[index]){
			count++;
			end++;
		}
		subset_helper(A, end, list);
		for(int j=1;j<=count;j++){
			list.add(A[index]);
			subset_helper(A,end,list);
		}
		
		for(int j=1;j<=count;j++){
			list.remove(list.size()-1);
			
		}
	}
	public static void main(String[] args){
		int[] A = new int[]{1,1,2};
		new Subset().subset(A);
		
	}
}

package dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> findComSum(int[] candidates, int target){
		if(candidates==null||candidates.length==0){
			return null;
		}
		Arrays.sort(candidates);
		List<List<Integer>> res=new LinkedList<List<Integer>>();
		helper(0,candidates,target,res,new LinkedList<Integer>());
		return res;
	}
	
	public void helper(int index,int[] can, int t, List<List<Integer>> res,LinkedList<Integer> list ){
		if(t==0){
			res.add(new LinkedList<Integer>(list));
			return;
		}
		if(index>=can.length||t<0||can[index]>t){
			return;
		}
		int k=index;
		while(k<can.length){
			int target=t;
			int i=1;
			int j=k;
			while(j<can.length-1 && can[j]==can[j+1]){
				i++;
				j++;
			}
			for(int m=0;m<i;m++){
				list.add(can[k]);
				target-=can[k];
				helper(k+i,can,target,res,list);
			}
			for(int f=0;f<i;f++){
				list.remove(list.size()-1);
			}
			k+=i;
		}
		
	}

}

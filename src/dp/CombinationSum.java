package dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSum c=new CombinationSum();
		List<List<Integer>> r=c.findComSum(new int[]{4,8,11,10,9,3,12,7,6}, 25);
		for(List<Integer> l:r){
			System.out.println(l.toString());
		}
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
		for(int k=index;k<can.length;k++){
			int target=t;
			int i=0;
			while(target>0){
				list.add(can[k]);
				target-=can[k];
				i++;
				helper(k+1,can,target,res,list);
			}
			for(int j=0; j<i;j++){
				list.remove(list.size()-1);
			}
		}
		
	}

}

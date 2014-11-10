package dp;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> test=new ArrayList<List<Integer>>();
		

	}
	
	public int minPathSum(List<List<Integer>> list){
		int level=list.size();//nLevels
		List<List<Integer>> res=new ArrayList<List<Integer>>(level);
		for(int i=0;i<level;i++){
			List<Integer> l=new ArrayList<Integer>(i+1);
			for(int j=0;j<=i;j++){
				l.add(Integer.MAX_VALUE);
			}
			res.add(l);
		}
		return helper(list,0,0,level, res);
	}
	/*
	 *                                         int curLevel, int index, int nLevels
	 */
	public int helper(List<List<Integer>> list, int l,int index,int tl,List<List<Integer>> res){
		if (res.get(l).get(index)!=Integer.MAX_VALUE){
			return res.get(l).get(index);
		}
		if (l==tl-1){
			int num=list.get(l).get(index);
			return num;
		}
		/*
		 *  the variable "e" should match to its meaning
		 */
		int e=Math.min(helper(list,l+1,index,tl,res), helper(list,l+1,index+1,tl,res))+list.get(l).get(index);
		res.get(l).set(index, e);
		return res.get(l).get(index);
	}

}

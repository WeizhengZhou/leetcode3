package dp;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreakII {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> wordBreakII(String s, Set<String> dict){
		if (s==null ||dict==null) return null;
		List<String> res=new LinkedList<String>();
		int[] check=new int[s.length()];
		for(int i=0;i<check.length;i++){
			check[i]=0;
		}
		helper(s,0,dict,res,"", check);
		return res;
	}

	public int helper(String s, int index, Set<String> dict, List<String> res, String list, int[] check){
		if (check[index]!=0) return check[index];
		String sub=s.substring(index);
		if (dict.contains(sub)){
			check[index]=1;
			list+=" "+sub;
			res.add(list);
		}
	}

}

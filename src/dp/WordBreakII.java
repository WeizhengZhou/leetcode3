package dp;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreakII {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> dict=new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		
		WordBreakII w=new WordBreakII();
		List<String> res=w.wordBreakII("catsanddog",dict);
		System.out.println(res);
	}
	
	public List<String> wordBreakII(String s, Set<String> dict){
		if (s==null ||dict==null) return null;
		List<String> res=new LinkedList<String>();
		boolean[] check=new boolean[s.length()+1];
		for(int i=0;i<s.length();i++){
			check[i]=false;
		}
		check[s.length()]=true;
		if(isBreakable(s,dict,check)){
			helper(s,0,dict,res,new StringBuilder());
		}
		
		return res;
	}

	public boolean isBreakable(String s, Set<String> dict, boolean[] check){
		for(int i=s.length()-1;i>=0;i--){
			for(int j=i+1;j<=s.length();j++){
				if(dict.contains(s.substring(i, j))&&check[j]){
					check[i]=true;
				}
			}
		}
		return check[0];
	}
	public void helper(String s, int index, Set<String> dict, List<String> res, StringBuilder sb){
		String sub=s.substring(index);
		if (dict.contains(sub)){
			res.add(sb.append(" "+sub).toString().trim());
			int c=sb.length();
			sb.delete(c-sub.length()-1,c);
		}
		for(int i=index+1;i<=s.length();i++){
			String t=s.substring(index,i);
			if (dict.contains(t)){
				/*
				 *  
				 */
				helper(s,i,dict,res,sb.append(" "+t));
				int c=sb.length();
				sb.delete(c-t.length()-1,c);
				
			}
		}
	}

}

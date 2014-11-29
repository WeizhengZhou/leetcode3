package dp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ConcateSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public List<Integer> findSubstring(String S, String[] L) {
		 List<Integer> res=new LinkedList<Integer>();
	    	if(S==null||S.length()==0||L==null){
	    		return res;
	    	}
	    	Map<String,Integer> map=new HashMap<String,Integer>();
	    	for(String s:L){
	    		if(!map.containsKey(s)){
	    			map.put(s, 1);
	    		}
	    		else{
	    			map.put(s, map.get(s)+1);
	    		}
	    	}
	    	for(int i=0;i<=S.length()-L.length*L[0].length();i++){
	    		helper(i,S,L, res,new HashMap<String,Integer>(map));
	    	}
	    	return res;
	 }
	 public void helper(int start,String S, String[] L,List<Integer> res,Map<String,Integer> map){
		 int s=start;
		 for(int i=0; i<L.length;i++){
			 String sub=S.substring(s, s+L[0].length());
			 if(map.containsKey(sub) && map.get(sub)>0){
				 map.put(sub, map.get(sub)-1);
			 }
			 else{
				 return;
			 }
			 s+=L[0].length();
		 }
		 res.add(start);
	 }
}

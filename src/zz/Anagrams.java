package zz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Anagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> anagrams(String[] strs) {
		List<String> res=new LinkedList<String>();
		if(strs==null || strs.length==0){
			return res;
		}
		Map<String,List<String>> map=new HashMap<String,List<String>>();
		for(int i=0;i<strs.length;i++){
			String key=sortChar(strs[i]);
			if(map.containsKey(key)){
				map.get(key).add(strs[i]);
			}
			else{
				List<String> list=new LinkedList<String>();
				list.add(strs[i]);
				map.put(key, list);
			}
		}
		for(String k:map.keySet()){
			if(map.get(k).size()>1){
				res.addAll(map.get(k));
			}
		}
		return res;
	}
	
	public String sortChar(String s){
		char[] charA=s.toCharArray();
		Arrays.sort(charA);
		return new String(charA);
	}
	

}

package string;

import java.util.*;
public class DuplicateWords{
	public List<String> duplicate(String s){
		s = s.trim().toLowerCase();
		String[] strs = s.split(" ");
		Map<String, Integer> map  = new HashMap<>();
		List<String> duplicates = new ArrayList<>();
		for(int i=0;i<strs.length;i++){
			if(!map.containsKey(strs[i]))
				map.put(strs[i],1);
			else
				map.put(strs[i],map.get(strs[i])+1);
		}
		Set<String> keySet = map.keySet();
		for(String t : keySet){
			if(map.get(t) > 1)
				duplicates.add(t);
		}
		return duplicates;
	}
	public static void main(String[] args){
		String s = "The dog is the cat, this is the bob";
		DuplicateWords solu = new DuplicateWords();
		List<String> res = solu.duplicate(s);
		System.out.println(res);		
	}
}

package additional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AnagramList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnagramList a=new AnagramList();
		Set<String> dict=new HashSet<String>();
		dict.add("cat");
		dict.add("tac");
		dict.add("dog");
		dict.add("god");
		dict.add("fish");
		List<List<String>> res=a.getAnagramList(dict);
		for(List<String> l:res){
			System.out.println(l.toString());
		}

	}
	
	public String convert(String S){
		char[] A=S.toCharArray();
		Arrays.sort(A);
		return new String(A);
	}
	
	public List<List<String>> getAnagramList(Set<String> dict){
		if(dict==null || dict.size()<2){
			return null;
		}
		Map<String,List<String>> map=new HashMap<String,List<String>>();
		for(String S:dict){
			String key=convert(S);
			if(map.containsKey(key)){
				map.get(key).add(S);
			}
			else{
				List<String> list=new LinkedList<String>();
				list.add(S);
				map.put(key, list);
			}
		}
		List<List<String>> res=new LinkedList<List<String>>();
		for(String k:map.keySet()){
			if(map.get(k).size()>1){
				res.add(map.get(k));
			}
		}
		return res;
	}

}

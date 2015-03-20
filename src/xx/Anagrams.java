package xx;
import java.util.*;
public class Anagrams {
	public List<String> anagrams(String[] strs) {
		List<String> res=new LinkedList<>();
		if(strs==null || strs.length<=1){
			return res;
		}
		Map<String,List<String>> map=new HashMap<>();
		for(int i=0;i<strs.length;i++){
			char[] charA=strs[i].toCharArray();
			Arrays.sort(charA);
			String key=new String(charA);
			List<String> list=map.get(key);
			if(list==null){
				list=new LinkedList<String>();
				map.put(key,list);
			}
			list.add(strs[i]);
		}
		for(String key: map.keySet()){
			if(map.get(key).size()>1){
				res.addAll(map.get(key));
			}
		}
		return res;
	}
}

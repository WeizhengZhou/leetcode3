package gogo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new LinkedList<> ();
        if (strs == null || strs.length == 0) return list;
        Map<String, List<String>> map = new HashMap<> ();
        for (int i=0; i<strs.length; i++) {
        	String c= strs[i];
            char[] sort = c.toCharArray();
        	Arrays.sort(sort);
            c = new String(sort);
    		List<String> item = map.get(c);
    		if (item == null) item = new LinkedList<String> ();
    		item.add(strs[i]);
    		map.put(c, item);
        }
        for (List<String> re:map.values()) {
        	list.add(re);
        }
        return list;
    }
}

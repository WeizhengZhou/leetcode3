package gogo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class PreferenceList {
	public static void main(String[] args) {
		PreferenceList p=new PreferenceList();
		List<List<Integer>> preference = new LinkedList<> ();
		preference.add(Arrays.asList(3,5,7,9));
		preference.add(Arrays.asList(2,3,8));
		preference.add(Arrays.asList(5,8));
		List<Integer> list=p.getPreferenceList(preference);
		System.out.println(list);
	}
	public List<Integer> getPreferenceList(List<List<Integer>> preference) {
		List<Integer> list=new LinkedList<> ();
		if (preference ==null || preference.size()==0) return list;
		Map<Integer, List<Integer>> map=new HashMap<> ();
		Map<Integer, Integer> degree=new HashMap<> ();
		for(List<Integer> l:preference) {
			for(int i=1;i<l.size();i++) {
				int pre=l.get(i-1);
				if (!map.containsKey(pre)) {
					map.put(pre, new LinkedList<Integer> ());
				}
				List<Integer> child=map.get(pre);
				child.add(l.get(i));
				if (!degree.containsKey(pre)) {
					degree.put(pre, 0);
				}
				if (!degree.containsKey(l.get(i))) {
					degree.put(l.get(i), 0);
				}
				degree.put(l.get(i), degree.get(l.get(i))+1);
			}
		}
		Queue<Integer> can=new LinkedList<> ();
		for(Integer key:degree.keySet()) {
			if (degree.get(key)==0) can.add(key);
		}
		while(!can.isEmpty()) {
			int top=can.poll();
			list.add(top);
			if (map.containsKey(top)) {
				List<Integer> child=map.get(top);
				for(int c:child) {
					degree.put(c, degree.get(c)-1);
					if (degree.get(c)==0) can.add(c);
				}
			}
		}
		return list;
	}
}

package gogo;

import java.util.LinkedList;
import java.util.List;

public class GrayCode {
	public List<Integer> grayCode(int n) {
		List<Integer> list = new LinkedList<> ();
		list.add(0);
		if (n<=0) return list;
		list.add(1);
		int base = 2;
		for (int i=1;i<n;i++){
			int size = list.size();
			for (int j=size-1;j>=0;j--) {
				list.add(list.get(j) + base);
			}
			base = base*2;
		}
		return list;
	}
}

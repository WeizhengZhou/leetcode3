//zz reviewed
package zz;

import java.util.LinkedList;
import java.util.List;

public class PascelTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res=new LinkedList<List<Integer>>();
		if(numRows<=0){
			return res;
		}
		List<Integer> list=new LinkedList<Integer>();
		list.add(1);
		res.add(new LinkedList<Integer>(list));
		if(numRows==1){
			return res;
		}
		//zz numRows == 2 can be absorbed in the for loop
		list.add(1);
		res.add(new LinkedList<Integer>(list));
		if(numRows==2){
			return res;
		}
		for(int i=3;i<=numRows;i++){
			List<Integer> pre=res.get(res.size()-1);
			List<Integer> cur=new LinkedList<Integer>();
			cur.add(1);
			for(int j=0;j<i-2;j++){
				cur.add(pre.get(j)+pre.get(j+1));
			}
			cur.add(1);
			res.add(cur);
		}
		return res;
	}
}

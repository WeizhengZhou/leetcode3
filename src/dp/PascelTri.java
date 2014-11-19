package dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PascelTri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> res=new LinkedList<List<Integer>>();
    	if(numRows==0){
    		return res;
    	}
    	List<Integer> list=new ArrayList<Integer>();
    	list.add(1);
    	res.add(list);
    	if(numRows==1){
    		return res;
    	}
    	List<Integer> l=new ArrayList<Integer>();
    	for(int i=1;i<numRows;i++){
    		l.add(1);
    		List<Integer> last=res.get(i-1);
    		for(int j=0;j<i-1;j++){
    			l.add(last.get(j)+last.get(j+1));
    		}
    		l.add(1);
    		res.add(new ArrayList<Integer>(l));
    		l.clear();
    	}
    	return res;
    }
}

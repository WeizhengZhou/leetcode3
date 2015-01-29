//zz reviewed
package zz;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PascalTriangleII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> getRow(int rowIndex) {
		List<Integer> list=new LinkedList<Integer>();
    	list.add(1);
    	if(rowIndex==0){
    		return list;
    	}
    	List<Integer> pre=list;
    	List<Integer> cur=new LinkedList<Integer>();
    	for(int i=1;i<=rowIndex;i++){
    		cur.add(1);
    		//List<Integer> last=list.get(i-1);
    		for(int j=0;j<i-1;j++){
    			cur.add(pre.get(j)+pre.get(j+1));
    		}
    		cur.add(1);
    		//list.add(new ArrayList<Integer>(l));
    		pre=new LinkedList<Integer>(cur);
    		cur.clear();
    	}
    	return pre;
	}

}

package dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PascalTriII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public List<Integer> getRow(int rowIndex) {
    	List<Integer> list=new ArrayList<Integer>();
    	
    	list.add(1);
    	if(rowIndex==0){
    		return list;
    	}
    	List<Integer> last=new ArrayList<Integer>();
    	List<Integer> l=new ArrayList<Integer>();
    	for(int i=1;i<=rowIndex;i++){
    		l.add(1);
    		
    		for(int j=0;j<i-1;j++){
    			l.add(last.get(j)+last.get(j+1));
    		}
    		l.add(1);
    		last=new ArrayList<Integer>(l);
    		l.clear();
    	}
    	return last;
    }
}

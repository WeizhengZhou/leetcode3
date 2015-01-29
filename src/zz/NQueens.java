//zz reviewed

package zz;

import java.util.LinkedList;
import java.util.List;

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<String[]> solveNQueens(int n) {
        List<String[]> res= new LinkedList<String[]>();
        if(n<=0){
        	return res;
        }
        build(0,n,new int[n],res);
        return res;
    }   
   	
    //zz, buildBoard(int curIndex, int n, int[] buf, List<String[]> res) 
    public void build(int index,int n, int[] buf, List<String[]> res){
    	if(index==n){
    		res.add(buildString(buf));//zz build solution
    		return;
    	}
    	for(int i=0;i<n;i++){//zz name the i more meaningful, for example, for each possible column position
    		if(check(index,i,n,buf)){//zz check->isValidBoard
    			buf[index]=i;
    			build(index+1,n,buf,res);
    		}
    	}
    }
    public String[] buildString(int[] buf){
    	String[] list=new String[buf.length];//zz name->board
    	for(int i=0;i<buf.length;i++){
    		int cur=buf[i];
    		StringBuffer sb=new StringBuffer();
		//zz two loops can be merged
    		for(int j=0;j<=cur-1;j++){
    			sb.append('.');
    		}
    		sb.append('Q');
    		for(int j=cur+1;j<buf.length;j++){
    			sb.append('.');
    		}
    		list[i]=sb.toString();
    	}
    	return list;
    }
    
    public boolean check(int index, int cur, int n, int[] buf){
    	for(int i=0;i<index;i++){
    		int pre=buf[i];//zz this pre seems not necessary
    		if(pre==cur){
    			return false;
    		}
    		if(Math.abs(index-i)==Math.abs(pre-cur)){
    			return false;
    		}
    	}
    	return true;
    }

}

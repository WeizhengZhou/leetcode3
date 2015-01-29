//zz reviewed
package zz;

import java.util.LinkedList;
import java.util.List;

public class NQueensII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int total=0;//zz avoid global variable, instead changing build's return the total
    public int totalNQueens(int n) {
        if(n<=0){
        	return 0;
        }
        build(0,n,new int[n]);
        return total;
    }
    
    public void build(int index,int n, int[] buf){
    	if(index==n){
    		total++;
    		return;
    	}
    	for(int i=0;i<n;i++){
    		if(check(index,i,n,buf)){
    			buf[index]=i;
    			build(index+1,n,buf);
    		}
    	}
    }
    public boolean check(int index, int cur, int n, int[] buf){
    	for(int i=0;i<index;i++){
    		int pre=buf[i];
    		if(pre==cur){//zz give simple comment
    			return false;
    		}
    		if(Math.abs(index-i)==Math.abs(pre-cur)){
    			return false;
    		}
    	}
    	return true;
    }
}

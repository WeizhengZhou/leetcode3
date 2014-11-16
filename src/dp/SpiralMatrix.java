package dp;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> res=new LinkedList<Integer>();
    	if (matrix==null||matrix.length==0||matrix[0]==null||matrix[0].length==0){
    		return res;
    	}
    	int m=matrix.length;
    	int n=matrix[0].length;
    	for (int d=0; d<Math.min(m, n)/2;d++){
    		for (int i=d;i<n-1-d;i++){
    			res.add(matrix[d][i]);
    		}
    		for (int i=d;i<m-1-d;i++){
    			res.add(matrix[i][n-1-d]);
    		}
    		for (int i=d;i<n-1-d;i++){
    			res.add(matrix[m-1-d][n-1-i]);
    		}
    		for (int i=d;i<m-1-d;i++){
    			res.add(matrix[m-1-i][d]);
    		}
    	}
    	if (Math.min(m, n)%2==1){
    		if(m<n){
    			for(int i=m/2;i<=n-1-m/2;i++){
    				res.add(matrix[m/2][i]);
    			}
    		}
    		else if(m>n){
    			for(int i=n/2;i<=m-1-n/2;i++){
    				res.add(matrix[i][n/2]);
    			}
    		}
    		else{
    			res.add(matrix[m/2][n/2]);
    		}
    	}
    	return res;
    }
}

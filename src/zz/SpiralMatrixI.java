package zz;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrixI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> res=new LinkedList<Integer>();
    	if(matrix==null || matrix.length==0 || matrix[0].length==0 ){
    		return res;
    	}
    	int n=matrix.length;
    	int m=matrix[0].length;
    	int layers=Math.min(m, n)/2;
    	for(int l=0;l<layers;l++){
    		for(int i=l;i<m-1-l;i++){
    			res.add(matrix[l][i]);
    		}
    		for(int i=l;i<n-1-l;i++){
    			res.add(matrix[i][m-1-l]);
    		}
    		for(int j=m-1-l;j>l;j--){
    			res.add(matrix[n-l-1][j]);
    		}
    		for(int i=n-1-l;i>l;i--){
    			res.add(matrix[i][l]);
    		}
    	}
    	if(n>m && m%2==1){
    		for(int i=layers;i<n-layers;i++){
    			res.add(matrix[i][layers]);
    		}
    	}
    	if(m>n && n%2==1){
    		for(int j=layers;j<m-layers;j++){
    			res.add(matrix[layers][j]);
    		}
    	}
    	if(m==n && m%2==1){
    		res.add(matrix[n/2][m/2]);
    	}
    	return res;
    }

}

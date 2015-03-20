package xx;
import java.util.*;
public class SpiralMatrix {
	 public List<Integer> spiralOrder(int[][] matrix) {
	    	List<Integer> res=new LinkedList<>();
	    	if(matrix.length==0 || matrix[0].length==0){return res;}
	    	int n=matrix.length;
	    	int m=matrix[0].length;
	    	int layers=Math.min(n,m)/2;
	    	for(int d=0;d<layers;d++){
	    	    for(int i=d;i<m-1-d;i++){
	    	        res.add(matrix[d][i]);
	    	    }
	    	    for(int i=d;i<n-1-d;i++){
	    	        res.add(matrix[i][m-1-d]);
	    	    }
	    	    for(int i=m-1-d;i>d;i--){
	    	        res.add(matrix[n-1-d][i]);
	    	    }
	    	    for(int i=n-1-d;i>d;i--){
	    	        res.add(matrix[i][d]);
	    	    }
	    	}
	    	if(m<=n && m%2==1){
	    	    for(int i=layers;i<=n-1-layers;i++){res.add(matrix[i][layers]);}
	    	}
	    	else if(n<m && n%2==1){
	    	    for(int i=layers;i<=m-1-layers;i++){res.add(matrix[layers][i]);}
	    	}
	    	return res;
	    }
}

//zz reviewed
//zz O(n) space required
package zz;

import java.util.List;

public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null || triangle.size()==0){
        	return 0;
        }
        int[][] min=new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        //int min=helper(0,0,triangle);
        //return min;
        for(int i=0;i<triangle.get(triangle.size()-1).size();i++){
        	min[min.length-1][i]=triangle.get(triangle.size()-1).get(i);
        }
        for(int i=triangle.size()-2;i>=0;i--){
        	for(int j=0;j<=i;j++){
        		min[i][j]=Math.min(min[i+1][j], min[i+1][j+1])+triangle.get(i).get(j);
        	}
        }
        return min[0][0];
    }
    
    public int helper(int level, int index, List<List<Integer>> triangle){
    	if(level==triangle.size()-1){
    		return triangle.get(triangle.size()-1).get(index);
    	}
    	int left=helper(level+1,index,triangle);
    	int right=helper(level+1,index+1,triangle);
    	return Math.min(left, right)+triangle.get(level).get(index);
    }
}

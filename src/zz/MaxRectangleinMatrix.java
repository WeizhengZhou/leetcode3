package zz;

import java.util.Stack;

public class MaxRectangleinMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public int maximalRectangle(char[][] matrix) {
		 if(matrix==null || matrix.length==0 || matrix[0].length==0 ){
			 return 0;
		 }
		 int[][] ones=new int[matrix.length][matrix[0].length];
		 for(int j=0;j<matrix[0].length;j++){
			 ones[0][j]=matrix[0][j]=='0'?0:1;
		 }
		 for(int i=1;i<matrix.length;i++){
			 for(int j=0;j<matrix[0].length;j++){
				 if(matrix[i][j]=='0'){
					 ones[i][j]=0;
				 }
				 else{
					 ones[i][j]=ones[i-1][j]+1;
				 }
			 }
		 }
		 int max=0;
		 for(int i=0;i<matrix.length;i++){
			 int size=largestRectangleArea(i,ones);
			 max=Math.max(max, size);
		 }
		 return max;
	 }
	 
	 public int largestRectangleArea(int row, int[][] matrix) {
		 	int[] height=matrix[row];
	        if(height==null || height.length==0){
	        	return 0;
	        }
	        Stack<Integer> stack=new Stack<>();
	        int max=0;
	        int i=0;
	        while(i<height.length){
	        	if(stack.isEmpty() || height[stack.peek()]<=height[i]){
	        		stack.push(i);
	        		i++;
	        	}
	        	else{
	        		int heightIndex=stack.pop();
	        		int leftIndex=stack.isEmpty()?-1:stack.peek();
	        		int size=height[heightIndex]*(i-leftIndex-1);
	        		max=Math.max(max, size);        		
	        	}
	        }
	        System.out.println(stack.size()+" ,stack[0]="+stack.peek());
	        int rightIndex=height.length;
	        while(!stack.isEmpty()){
	        	int heightIndex=stack.pop();
	    		int leftIndex=stack.isEmpty()?-1:stack.peek();
	    		int size=height[heightIndex]*(rightIndex-leftIndex-1);
	    		max=Math.max(max, size); 
	        }
	        return max;
	    }
}

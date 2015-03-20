package xx;
import java.util.*;
public class MaxRectangle {
	public int maximalRectangle(char[][] matrix) {
		if(matrix==null || matrix.length==0 || matrix[0].length==0){return 0;}
		int[][] ones=new int[matrix.length][matrix[0].length];
		for(int i=0;i<matrix[0].length;i++){
			ones[0][i]=matrix[0][i]=='0'?0:1;
		}
		for(int i=1;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				ones[i][j]=matrix[i][j]=='0'?0:ones[i-1][j]+1;
			}
		}
		int maxArea=0;
		for(int i=0;i<matrix.length;i++){
			int rowMax=findMaxRectangle(i,ones);
			maxArea=Math.max(maxArea,rowMax);
		}
		return maxArea;
	}

	private int findMaxRectangle(int row,int[][] ones){
		int[] A=ones[row];
		Stack<Integer> stack=new Stack<>();
		int max=0;
		int i=0;
		while(i<A.length){
			if(stack.isEmpty() || A[stack.peek()]<=A[i]){stack.push(i++);}
			else{
				int height=A[stack.pop()];
				int leftEdge=stack.isEmpty()?-1:stack.peek();
				int size=(i-1-leftEdge)*height;
				max=Math.max(max,size);
			}
		}
		int rightEdge=A.length;
		while(!stack.isEmpty()){
			int height=A[stack.pop()];
			int leftEdge=stack.isEmpty()?-1:stack.peek();
			int size=(rightEdge-leftEdge-1)*height;
			max=Math.max(max,size);
		}
		return max;
	}

}

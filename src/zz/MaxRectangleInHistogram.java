package zz;

import java.util.Stack;

public class MaxRectangleInHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxRectangleInHistogram m=new MaxRectangleInHistogram();
		System.out.println(m.largestRectangleArea(new int[]{1}));
	}
	public int largestRectangleArea(int[] height) {
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

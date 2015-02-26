package xx;

public class LargestRectangleHistgram {
	public int largestRectangleArea(int[] height) {
		if(height==null || height.length==0){
			return 0;
		}
		Stack<Integer> stack=new Stack<>();
		int i=0;
		int maxArea=0;
		while(i<height.length){
			if(stack.isEmpty() || height[stack.peek()]<height[i]) stack.push(i++);
			else{
				int length=height[stack.pop()];
				int left=stack.isEmpty()?-1:stack.peek();
				int curArea=length*(i-left-1);
				maxArea=Math.max(maxArea,curArea);
			}
		}
		int right=height.length;
		while(!stack.isEmpty()){
			int length=height[stack.pop()];
			int left=stack.isEmpty()?-1:stack.peek();
			int curArea=length*(right-left-1);
			maxArea=Math.max(maxArea,curArea);
		}
		return maxArea;
	}
}

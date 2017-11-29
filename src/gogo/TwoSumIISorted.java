package gogo;

public class TwoSumIISorted {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers==null || numbers.length<2) return null;
        int i=0;
        int j=numbers.length-1;
        while(i<=j && numbers[i]+numbers[j] !=target) {
        	if (numbers[i]+numbers[j]<target) i++;
        	if (numbers[i]+numbers[j]>target) j--;
        }
        return new int[] {i+1,j+1};
    }
}

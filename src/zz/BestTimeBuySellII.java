
//zz reviewed
package zz;

public class BestTimeBuySellII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//zz O(1) space required
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0){
        	return 0;
        }
        int[] diff=new int[prices.length-1];
        int max=0;
        for(int i=0;i<prices.length-1;i++){
        	diff[i]=prices[i+1]-prices[i];
        	if(diff[i]>0){
        		max+=diff[i];
        	}
        }
        return max;
    }
}

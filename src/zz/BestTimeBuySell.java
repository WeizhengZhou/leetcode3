
//zz reviewed
package zz;

public class BestTimeBuySell {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//zz, you used O(n) space,
	//zz, no need to store the "diff"
	//zz, O(1) space is possible, 
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0){
        	return 0;
        }
        int[] diff=new int[prices.length-1];
        int max=0;//zz, maxProfit or maxEarn
        int curMax=0;
        for(int i=0;i<prices.length-1;i++){
        	diff[i]=prices[i+1]-prices[i];
        	curMax=curMax+diff[i];
        	max=Math.max(max, curMax);//zz, why update curMax after update globalMax?
        	curMax=Math.max(0, curMax);
        }
        return max>0?max:0;
    }

}

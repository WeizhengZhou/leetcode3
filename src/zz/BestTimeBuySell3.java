package zz;

import java.util.Arrays;

public class BestTimeBuySell3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BestTimeBuySell3 b=new BestTimeBuySell3();
		System.out.println(b.maxProfit(new int[]{2,1,2,0,1}));

	}
	
	public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0){
        	return 0;
        }
        int[] diff=new int[prices.length-1];
        int[] left=new int[prices.length];
        int[] right=new int[prices.length];
        int max=0;
        int currentMax=0;
        left[0]=0;
        right[prices.length-1]=0;
        for(int i=0;i<prices.length-1;i++){
        	diff[i]=prices[i+1]-prices[i];
        	currentMax=Math.max(currentMax+diff[i], 0);
        	max=Math.max(max, currentMax);
        	left[i+1]=max;
        }
        currentMax=0;
        max=0;
        int res=0;
        for(int i=prices.length-2;i>=0;i--){
        	currentMax=Math.max(0, currentMax+diff[i]);
        	max=Math.max(max, currentMax);
        	right[i]=max;
        	//System.out.println(left[i]+right[i]);
        	res=Math.max(res, left[i]+right[i]);
        	//System.out.println("res="+res);
        }
        res=Math.max(res, left[prices.length-1]);
        /*System.out.println("res="+res);
        System.out.println(Arrays.toString(diff));
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));*/
        return res;
    }

}

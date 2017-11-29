package gogo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class RoundedNumber {
	public static void main(String[] args) {
		RoundedNumber r=new RoundedNumber();
		int[] round=r.getRoundedNumber(new double[] {30.9, 2.4, 3.9});
		System.out.println(Math.log(2.0));
	}
	public int[] getRoundedNumber(double[] prices) {
		if (prices== null || prices.length==0) return new int[0];
		int len=prices.length;
		int[] rounded=new int[len];
		double sum=0;
		int floorSum=0;
		PriorityQueue<double []> q=new PriorityQueue<> (len, new Comparator<double []> () {
			public int compare(double[] a, double[] b) {
				if (a[1]-b[1]<0.000001) return 0;
				return a[1]<b[1] ? 1 : -1;
			}
		});

		for(int i=0;i<len;i++) {
			sum+=prices[i];
			double price=prices[i];
			int floor=(int)Math.floor(price);
			rounded[i]=floor;
			floorSum+=floor;
			q.add(new double[] {i, Math.abs(price-floor)});
		}
		int targetSum=(int)Math.floor(sum);
		while(targetSum>floorSum) {
			double[] pair=q.poll();
			floorSum++;
			rounded[(int)pair[0]]++;
		}
		return rounded;
	}
}

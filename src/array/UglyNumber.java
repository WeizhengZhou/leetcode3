package array;

import java.util.*;
public class UglyNumber {
	public void uglyNumber(){
		int n = 20;
		int[] ugly = new int[n];
		ugly[0] = 1;
		int p2 = 0;
		int p3 = 0;
		int p5 = 0;
		int min = 1;
		//for each iteration, ugly[p2-k] * 2, ugly[p3-k]*3, and ugly[p5-k]*5 are all considered 
		//the ugly[p2], ugly[p3] and ugly[p5] are like the frontier of the search
		for(int i=1;i<n;i++){
			min = Math.min(ugly[p2]*2, ugly[p3]*3);
			min = Math.min(min,ugly[p5]*5);
			if(min == ugly[p2]*2)
				p2++;
			if(min == ugly[p3]*3)
				p3++;
			if(min == ugly[p5]*5)
				p5++;
			ugly[i] = min;		
			System.out.println("i = " + i + ", p2 == " + p2 + ", p3 = " + p3 + ", p5 = " + p5 + ", min = " + min);			
		}
	}

	public static void main(String[] args){
		UglyNumber solu = new UglyNumber();
		solu.uglyNumber();
	}
}

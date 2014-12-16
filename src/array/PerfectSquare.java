package array;

import java.util.*;
public class PerfectSquare {
	public void perfectSquareNumber(int d){
//	    System.out.println(Math.sqrt(Math.pow(10, d)));
		long x = (long) Math.pow(10,d/2);
		while(x < (long) Math.sqrt(Math.pow(10, d+1))){
//			System.out.println(x);
			long square = (long) Math.pow(x, 2);
			BitSet bt = new BitSet(10);
			while(square != 0){
				int s = (int) (square%10);
				if(bt.get(s))
					break;
				else
					bt.set(s);
				square /= 10;
			}
			if(square == 0){
				System.out.println("x = " + x + ", square = " + (int) Math.pow(x, 2));
			}
			x++;
		}
	}	
	
	public static void main(String[] args){
//		System.out.println(Integer.MAX_VALUE);
		PerfectSquare  solu = new PerfectSquare ();
		solu.perfectSquareNumber(10);
	}
}

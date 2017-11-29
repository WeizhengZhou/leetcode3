package Graph;

import java.util.*;
public class CircularArray {
	private final int SIZE = 6;
	private int[] sec = new int[SIZE];
	private int[] min = new int[SIZE];
	private int secInd = 0;
	private int minInd = 0;
	public CircularArray(){
		long timeInMillis = System.currentTimeMillis();
		int secInd = (int) ((timeInMillis * 1000) % SIZE);
		int minInd = (int) ((timeInMillis * 1000 / SIZE) % (SIZE));
	}
//	public boolean increase(int x){
//		
//		
//	}
	public static void main(String[] args){
//		long timeInMillis = System.currentTimeMillis();
//		int secInd = (int) ((timeInMillis * 1000) % 60);
//		int minInd = (int) ((timeInMillis * 1000 / 60) % (60));
//		Date date = new Date(timeInMillis);
//		System.out.println(date.get);
//		System.out.println(date);
//		System.out.println(secInd);
//		System.out.println(minInd);
	}
}

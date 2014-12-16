package array;

import java.util.*;
public class CtrlA_CtrlC_CtrlP {
//	public void compute(int n){
//		if(n <= 0) return;
//		int[] table = new int[n+1];
//		int[] table = new int[]{0,1,2,3,4,5,6,9,12,16,20};
//		
//	}

	public static void main(String[] args){
		CtrlA_CtrlC_CtrlP solu = new CtrlA_CtrlC_CtrlP();
		int n = 100;
		long[] table = new long[n+1];
		table[0] = 0;
		table[1] = 1;
		table[2] = 2;
		table[3] = 3;
		table[4] = 4;
		table[5] = 5;
		table[6] = 6;
		table[7] = 7;	
		for(int i=8;i<table.length;i++){
			long max = table[i-1] + (table[i-1] - table[i-2]);//Continue Paste, 
			for(int j = 1;j<=i-2;j++){//Select + Copy + (i-j-2) Paste
				max = Math.max(max,table[j] * (i-j-2));
			}
			table[i] = max;
		}
		for(int i=0;i<table.length;i++){
			System.out.println(i + " : " + table[i]);
		}		
	}
}

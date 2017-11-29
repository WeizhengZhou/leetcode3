package gogo;

import java.util.LinkedList;
import java.util.List;

public class CountBits {
    public int[] countBits(int num) {
    	int[] a=new int[num+1];
        if (num<0) return new int[0];
       
        a[0]=0;
        int i=1;
        int j=0;
        long range=2;
        while(i<=num) {
        	a[i++]=a[j++]+1;
        	if(i==range) {
        		j=0;
        		range=range*2;
        	}        	
        }
        return a;
    }
}

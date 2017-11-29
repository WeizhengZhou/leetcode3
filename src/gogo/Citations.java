package gogo;

import java.util.Arrays;

public class Citations {
    public int hIndex(int[] citations) {
        if (citations==null || citations.length==0) return 0;
        Arrays.sort(citations);
        for(int i=0;i<citations.length;i++) {
        	if (citations[i]>=citations.length-i) return citations.length-i;
        }
        return 0;
    }
}

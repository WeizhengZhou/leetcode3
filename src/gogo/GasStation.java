package gogo;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas==null||cost==null|| gas.length==0||cost.length==0) return -1;
        int left = 0;
        int start=0;
        boolean second= false;
        int i=0;
        while(i<gas.length || !second) {
        	if (left+gas[i]<cost[i]) {
        		start=i+1;
        		if (start>=gas.length) return -1;
        		left=0;
        		
        	} else {
        		left = left+gas[i]-cost[i];
        	}
        	i++;
        	if (i>=gas.length && !second) {
        		i=0; second=true;
        	}
        	if (second && i==start) {
        		return start;
        	}
        }
        return -1;
    }
}

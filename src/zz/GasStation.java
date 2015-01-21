//zz reviewed

package zz;

public class GasStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	int[] net=new int[gas.length];
    	int sum=0;
    	int start=-1;
    	for(int i=0;i<gas.length;i++){
    		net[i]=gas[i]-cost[i];
    		sum+=net[i];
    		if(net[i]<0){
    			start=i;
    		}
    	}
    	if(sum<0){
    		return -1;
    	}
    	int j=start;
    	int begin=-1;
    	int currentSum=0;
    	int max=-1;
    	for(;j>=0;j--){
    		if(net[j]>0){
	    		currentSum=currentSum+net[j];	    		
	    		//currentSum=Math.max(currentSum, 0);
    		}
    		else{
    			currentSum=0;
    		}
    		if(currentSum>max){
    			max=currentSum;
    			begin=j;
    		}
    	}
    	//if(net[0]>=0 && net[gas.length-1]>=0){
    		for(j=gas.length-1;j>start;j--){
    			if(net[j]>0){
    	    		currentSum=currentSum+net[j];	    		
    	    		//currentSum=Math.max(currentSum, 0);
        		}
        		else{
        			currentSum=0;
        		}
        		if(currentSum>max){
        			max=currentSum;
        			begin=j;
        		}
    		}
    	//}
    	return begin;
    }

}

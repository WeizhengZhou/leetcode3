package xx;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas==null || cost==null || gas.length!=cost.length){return -1;}
        int start=0;
        if(gas.length==1){return gas[0]>=cost[0]?start:-1;}
        int i=1;
        int count=0;
        int remain=gas[0]-cost[0];
        while(count<2){
            if(start==i) return remain>=0?start:-1;
            if(remain<0){
                start=i;
                remain=gas[i]-cost[i];
            }
            else{
                remain+=gas[i]-cost[i];
            }
            i++;
            if(i==gas.length){i=0;count++;}
        }
        return -1;
    }
}

package dp;

public class GasStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
GasStation g=new GasStation();
System.out.println(g.canCompleteCircuit(new int[]{5,0,9,4,3,3,9,9,1,2},new int[]{6,7,5,9,5,8,7,1,10,5}));
	}
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas==null||cost==null||gas.length==0||gas.length!=cost.length){
        	return 0;
        }
        if(gas.length==1){
        	return gas[0]>=cost[0]?0:-1;
        }
        int l=gas.length;
        int[] remain=new int[l];
        int re=0;
        for(int i=0; i<l;i++){
        	remain[i]=gas[i]-cost[i];
        	re+=remain[i];
        }
        if(re<0){
        	return -1;
        }
        int s=0;
        int e=l-1;
        System.out.println("s="+s+",e="+e);
        if(remain[0]>0&&remain[l-1]>0){
        	int j=l-1;
        	while(j>=0 && remain[j]>0){
        		j--;
        	}
        	s=j-1;
        	e=j;
        }
        System.out.println("s="+s+",e="+e);
        int max=0;
        int start=-1;
        int pre=0;
        for(int i=e;i>=0;i--){
        	if(remain[i]<=0){
        		System.out.println("pre="+pre);
        		if(pre>max){
        			max=pre;
        			start=i+1;
        		}
        		pre=0;
        	}
        	else{
        		pre+=remain[i];        		
        	}
        }
        if(s>0){
        	for(int i=l-1;i>=s;i--){
            	if(remain[i]<=0){
            		if(pre>max){
            			max=pre;
            			start=(i+1)%l;
            		}
            		pre=0;
            	}
            	else{
            		pre+=remain[i];        		
            	}
            }
        }
        return start;
    }
}

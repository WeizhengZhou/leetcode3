//zz NOT reviewed
package zz;

public class MaxCap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxCap m=new MaxCap();
		System.out.println(m.maximumGap(new int[]{7,2,7,3,9}));

	}
	
	class Pair{
		int first;
		int second;
		Pair(int x, int y){
			first=x;
			second=y;
		}
	}
	
    public int maximumGap(int[] num) {
        if(num==null || num.length<2){
        	return 0;
        }
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<num.length;i++){
        	min=Math.min(min, num[i]);
        	max=Math.max(max, num[i]);
        }
        double gap=(max-min)/(num.length-1.0);
        //System.out.println(gap);
        Pair[] bucket=new Pair[num.length];
        int index=0;
        for(int i=0;i<num.length;i++){
        	if(num[i]!=min && num[i]!=max)
        	{
        		index=(int)Math.round((num[i]-min)/gap);
        		//System.out.println(index);
        		if(bucket[index]==null){
        			bucket[index]=new Pair(num[i],num[i]);        			   			
        		}
        		else{
        			bucket[index].first=Math.min(bucket[index].first, num[i]);
        			bucket[index].second=Math.max(bucket[index].second, num[i]);
        		}
        	}
        }
        int maxGap=0;
        int currentGap=0;
        int last=min;
        for(int j=0;j<bucket.length;j++){
        	if(bucket[j]!=null){
            	currentGap=bucket[j].first-last;
            	maxGap=Math.max(maxGap,currentGap);
            	last=bucket[j].second;
        	}
        }
        maxGap=Math.max(maxGap,max-last);
        return maxGap;
    }

}

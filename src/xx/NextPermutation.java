package xx;

public class NextPermutation {
	public void nextPermutation(int[] num) {
		if(num==null || num.length<=1) return;
		//find first element[i]<element[i+1]
		int i=num.length-2;
		while(i>=0){
			if(num[i]<num[i+1]){break;}
			i--;
		}
		if(i<0) {
                        Arrays.sort(num);
                        return;
                }
		
		//find min(num[i+1...last]>num[i])
		int min=Integer.MAX_VALUE;
		int j=num.length-1;
		int minIndex=0;
		while(j>i){
			if(num[j]>num[i]&& num[j]<min){
				min=num[j];
				minIndex=j;
			}
			j--;
		}
		//swap num[i] & num[j]
		int temp=num[i];
		num[i]=num[minIndex];
		num[minIndex]=temp;
		
		//sort num[j...last]
		int[] sortA=Arrays.copyOfRange(num,i+1,num.length);
		Arrays.sort(sortA);
		int si=0;
		for(int k=i+1;k<num.length;k++){
			num[k]=sortA[si++];
			
		}
	}
}

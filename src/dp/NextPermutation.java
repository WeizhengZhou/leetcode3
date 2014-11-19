package dp;

import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public void nextPermutation(int[] num) {
        if(num==null||num.length<=1){
        	return;
        }
        int i=num.length-2;
        int d=-1;
        while(i>=0){
        	if(num[i]<num[i+1]){
        		d=i;
        		break;
        	}
        	i--;
        }
        if(d==-1){
        	Arrays.sort(num);
        	return;
        }
        else{
        	int min=Integer.MAX_VALUE;
        	int minIn=-1;
        	for(int j=d+1;j<num.length;j++){
        		if(num[j]>num[d]){
        			if(num[j]<min){
        				min=num[j];
        				minIn=j;
        			}
        		}
        	}
        	int temp=num[d];
        	num[d]=num[minIn];
        	num[minIn]=temp;
        	int[] s=Arrays.copyOfRange(num, d+1, num.length);
        	Arrays.sort(s);
        	int k=0;
        	for(int j=d+1;j<num.length;j++){
        		num[j]=s[k];
        		k++;
        	}
        }
    }

}

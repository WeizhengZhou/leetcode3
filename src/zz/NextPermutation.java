package zz;

import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void nextPermutation(int[] num) {
		if(num==null || num.length==0){
			return;
		}
		int i=num.length-1;
		int pre=num[i];
		int smallIndex=i-1;
		while(smallIndex>=0){
			if(num[smallIndex]<pre){
				break;
			}
			pre=num[smallIndex];
			smallIndex--;
		}
		if(smallIndex<0){
			Arrays.sort(num);
			return;
		}
		i=num.length-1;
		int min=Integer.MAX_VALUE;
		int minIndex=num.length-1;
		while(i>smallIndex){
			if(num[i]>num[smallIndex] && num[i]<min){
				min=num[i];
				minIndex=i;
			}
			i--;
		}
		swap(minIndex,smallIndex,num);
		int[] SortA=Arrays.copyOfRange(num, smallIndex+1, num.length);
		Arrays.sort(SortA);
		int k=0;
		for(int j=smallIndex+1;j<num.length;j++){
			num[j]=SortA[k];
			k++;
		}
	}
	
	public void swap(int x, int y, int[] A){
		int temp=A[x];
		A[x]=A[y];
		A[y]=temp;
	}

}

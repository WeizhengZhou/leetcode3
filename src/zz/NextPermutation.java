//zz reviewed

package zz;

import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//zz divide this method into three blocks
	//zz find"SmallIndex" to find the first non-increasing index from right to left
	//zz find"SuccessorIndex" to find the successor index of smallIndex
	//zz swap
	//zz sort the tail of array
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
		//zz sort directly, no need to copy
		//zz  Arrays.sort(num,index+1,num.length);
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

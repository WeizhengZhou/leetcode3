package additional;

import java.util.Arrays;

public class NextLargerNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextLargerNumber n=new NextLargerNumber();
		System.out.println(n.getNextLargerNum(531));
	}
	
	public int getNextLargerNum(int N){
		if(N<10){
			return N;
		}
		char[] A=Integer.toString(N).toCharArray();
		int n=N;
		int max=0;
		int i=0;
		int digit=0;
		while(n!=0){
			digit=n%10;
			n=n/10;
			if(digit<max){
				break;
			}
			i++;
			max=Math.max(max, digit);
		}
		System.out.println("i="+i+",digit="+digit);
		if(digit>=max){
			return N;
		}
		int min=9;
		int k=0;
		System.out.println(Arrays.toString(A));
		for(int j=A.length-1; j>=A.length-i;j--){
			int x=A[j]-'0';
			if(A[j]-'0'>digit){
				if(x<min){
					k=j;
				}
				min=Math.min(min, A[j]-'0');				
			}
		}
		System.out.println("k="+k+",min="+min);
		char temp=A[A.length-1-i];
		A[A.length-1-i]=A[k];
		A[k]=temp;
		char[] sort=Arrays.copyOfRange(A, A.length-i, A.length);
		Arrays.sort(sort);
		for(int l=0;l<sort.length;l++){
			A[i+1+l]=sort[l];
		}
		String s=new String(A);
		return Integer.parseInt(s);		
	}

}

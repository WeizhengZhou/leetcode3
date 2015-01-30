package zz;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public String largestNumber(int[] num) {
		 Integer[] A=new Integer[num.length];
		 for(int i=0;i<num.length;i++){
			 A[i]=num[i];
		 }
		 Arrays.sort(A,new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				 int divisor1=10;
				 int divisor2=10;
				 while(o1/divisor1>0){
					 divisor1*=10;
				 }
				 while(o2/divisor2>0){
					 divisor2*=10;
				 }
				 /*int digit1=0;
				 int digit2=0;
				 while(divisor1!=0 || divisor2!=0){
					 if(divisor1!=0){
						 digit1=o1/divisor1;
						 o1=o1%divisor1;
						 divisor1/=10;
					 }
					 if(divisor2!=0){
						 digit2=o2/divisor2;
						 o2=o2%divisor2;
						 divisor2/=10;
					 }
					 if(digit1!=digit2){
						 return digit2-digit1;
					 }
				 }*/
				return o2*divisor1+o1-o1*divisor2-o2;
			}});
		 StringBuilder buf=new StringBuilder();
		 for(int i=0;i<A.length;i++){
			 buf.append(A[i]);
		 }
		 return buf.substring(0,1).equals("0")?"0":buf.toString();
	 }
}

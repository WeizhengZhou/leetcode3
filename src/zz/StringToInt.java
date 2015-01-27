package zz;

public class StringToInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(Integer.MAX_VALUE);
		StringToInt s=new StringToInt();
		System.out.println(s.atoi("-2147483648"));

	}
	 public int atoi(String str) {
		 if(str==null)
		 {
			 return 0;
		 }
		 str=str.trim();
		 boolean isPos=true;
		 int start=0;
		 if(str.charAt(start)=='-'){
			 start=1;
			 isPos=false;
		 }	
		 else if(str.charAt(start)=='+'){
			 start++;
		 }
		 if(str.charAt(start)<'0' || str.charAt(start)>'9'){
			 return 0;
		 }
		 int end=str.length()-1;
		 while(end>=0 && (str.charAt(end)<'0'||str.charAt(end)>'9')){
			 end--;			 
		 }
		 if(end<0){
			 return 0;
		 }
		 str=str.substring(start,end+1);
		 if(str.length()==0){
			 return 0;
		 }
		 int res=0;
		 System.out.println("("+str+")");
		 for(int i=0;i<str.length();i++){
			 int cur=str.charAt(i)-'0';
			 if(cur<0 || cur>9){
				 break;
			 }
			 System.out.println(cur);
			 if(res==0 || res>=(Integer.MIN_VALUE+cur)/10){
				 res=10*res-cur;
			 }
			 else{
				 if(isPos){
					 return Integer.MAX_VALUE;
				 }
				 else{
					 return Integer.MIN_VALUE;
				 }
			 }
		 }
		 if(isPos){
			 if(res==Integer.MIN_VALUE){
				 return Integer.MAX_VALUE;
			 }
			 return -res;
		 }
		 else{
			 return res;
		 }
	 }

}

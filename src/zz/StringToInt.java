package zz;

public class StringToInt {

//	 public int atoi(String str) {
//		 if(str==null)
//		 {
//			 return 0;
//		 }
//		 str=str.trim();
//		 boolean isPos=true;
//		 int start=0;
//		 if(str.charAt(start)=='-'){
//			 start=1;
//			 isPos=false;
//		 }	
//		 else if(str.charAt(start)=='+'){
//			 start++;
//		 }
//		 if(str.charAt(start)<'0' || str.charAt(start)>'9'){
//			 return 0;
//		 }
//		 int end=str.length()-1;
//		 while(end>=0 && (str.charAt(end)<'0'||str.charAt(end)>'9')){
//			 end--;			 
//		 }
//		 if(end<0){
//			 return 0;
//		 }
//		 str=str.substring(start,end+1);
//		 if(str.length()==0){
//			 return 0;
//		 }
//		 int res=0;
//		 System.out.println("("+str+")");
//		 for(int i=0;i<str.length();i++){
//			 int cur=str.charAt(i)-'0';
//			 if(cur<0 || cur>9){
//				 break;
//			 }
//			 System.out.println(cur);
//			 if(res==0 || res>=(Integer.MIN_VALUE+cur)/10){
//				 res=10*res-cur;
//			 }
//			 else{
//				 if(isPos){
//					 return Integer.MAX_VALUE;
//				 }
//				 else{
//					 return Integer.MIN_VALUE;
//				 }
//			 }
//		 }
//		 if(isPos){
//			 if(res==Integer.MIN_VALUE){
//				 return Integer.MAX_VALUE;
//			 }
//			 return -res;
//		 }
//		 else{
//			 return res;
//		 }
//	 }
	 
	 //zz see my new code below
	 public int atoi(String str) {
	        if(str == null || str.length() ==0) return 0;
	        int i = 0;
	        while(i<str.length() && str.charAt(i) == ' ') i++;
	        if(i == str.length()) return 0;
	        boolean isPos = true;
	        if(str.charAt(i) == '+') i++;
	        if(str.charAt(i) == '-'){
	            isPos = false;
	            i++;
	        }
	        long res = 0;
	        boolean isOverflow = false;
	        while(i<str.length()){
	            if(isNumber(str.charAt(i)) == false) break;
	            res = res*10 + (str.charAt(i)-'0');
	            if(isPos == true && res > Integer.MAX_VALUE) isOverflow = true;
	            if(isPos == false && res > (long) Integer.MAX_VALUE+1) isOverflow = true;
	            i++;
	        }
//	        while(i<str.length()){
//	            if(str.charAt(i) != ' ') return 0;
//	            i++;
//	        }
	        if(isOverflow == true)
	        	return isPos == true?Integer.MAX_VALUE:Integer.MIN_VALUE;
	        else
	        	return isPos == true? (int) res: (int) -res;
	    }
	    private boolean isNumber(char c){
	        return c<='9'&&c>='0';
	    }

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			//System.out.println(Integer.MAX_VALUE);
			StringToInt s=new StringToInt();
			System.out.println(s.atoi(Integer.MIN_VALUE + ""));

		}

}

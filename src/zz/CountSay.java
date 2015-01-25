package zz;

public class CountSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public String countAndSay(int n) {
		 if(n<=0){
			 return "";
		 }
		 String last="1";
		 int i=1;
		 for(;i<n;i++){
			 char pre=last.charAt(0);
			 int count=0;
			 StringBuilder sb=new StringBuilder();
			 for(int j=0;j<last.length();j++){
				 if(last.charAt(j)==pre){
					 count++;					 
				 }
				 else{
					 sb.append(count);
					 sb.append(pre);
					 count=1;
					 pre=last.charAt(j);
				 }
			 }
			 sb.append(count);
			 sb.append(pre);
			 last=sb.toString();
		 }
		 return last;
	 }

}

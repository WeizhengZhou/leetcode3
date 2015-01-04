package zz;

public class ReverseWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public String reverseWords(String s) {
		 if(s==null){
			 return "";
		 }
		 s=s.trim();
		 int i=s.length()-1;
		 int end=0;
		 StringBuilder sb=new StringBuilder();
		 while(i>=0){
			 end=i;
			 while(i>=0 && s.charAt(i)!=' '){
				 i--;
			 }
			 sb.append(s.substring(i+1, end+1));
			 sb.append(" ");
			 while(i>=0 && s.charAt(i)==' '){
				 i--;
			 }
		 }
		 return sb.toString().trim();
	 }
}

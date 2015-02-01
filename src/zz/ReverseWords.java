//zz reviewed
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
			 sb.append(s.substring(i+1, end+1));//zz, start = i+1; then word = s.substring(start,end)
			 sb.append(" ");
			 while(i>=0 && s.charAt(i)==' '){
				 i--;
			 }
		 }
		 return sb.toString().trim();
	 }
	//zz another solution
        public String reverseWords(String s){
    	    if(s == null) return "";
            s = s.trim().replaceAll(" +", " ");//trim leading and tailing spaces, then replace multiple spaces with one space  
            String[] strs = s.split(" ");//split string, sepearted by space
            if(strs == null || strs.length == 0) return "";
            StringBuilder sb = new StringBuilder();
            for(int i=strs.length-1;i>=0;i--){
        	sb.append(strs[i].trim());
                if(i != 0) 
 		    sb.append(" ");
             }
             return sb.toString();
	}
/*

*/
}

package dp;

public class LongestPaliSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public String longestPalindrome(String s) {
         if(s==null||s.length()==0){
        	 return "";
         }
         boolean[][] isPali=new boolean[s.length()][s.length()];
         int start=0;
         int end=0;
         for(int i=0;i<s.length();i++){
        	 isPali[i][i]=true;
         }
         for(int i=0;i<s.length()-1;i++){
        	 if(s.charAt(i)==s.charAt(i+1))
        	 {
        		 isPali[i][i+1]=true;
        		 start=i;
    			 end=i+1;
        	 }
         }

         for(int d=2;d<s.length();d++){
        	 for(int i=0;i<s.length()-d;i++){
        		 int j=i+d;
        		 if(isPali[i+1][j-1]&&s.charAt(i)==s.charAt(j)){
        			 isPali[i][j]=true;
        			 start=i;
        			 end=j;
        		 }
        	 }
         }
         return s.substring(start, end+1);
    }
}

package xx;

public class LongestValidParenthesis {
	 public int longestValidParentheses(String s) {
	       if(s==null || s.length()<=1){return 0;}
	        int len=s.length();
	        int[] nWays=new int[len];
	        nWays[len-1]=0;
	        int max=0;
	        for(int i=len-2;i>=0;i--){
	            char c=s.charAt(i);
	            if(c==')'){nWays[i]=0;}
	            else{
	                char next=s.charAt(i+1);
	                if(next==')'){
	                    int nextLen=0;
	                    if(i+2<len && s.charAt(i+2)=='('){nextLen=nWays[i+2];}
	                    nWays[i]=2+nextLen;
	                }
	                else{
	                    int nextIndex=i+nWays[i+1]+1;
	                    int nextLen=0;
	                    if(nextIndex<len && s.charAt(nextIndex)==')'){
	                        nextLen=2+nWays[i+1];
	                        if(nextIndex+1<len){nextLen+=nWays[nextIndex+1];}
	                    }
	                    nWays[i]=nextLen;
	                }
	            }
	            max=Math.max(max,nWays[i]);
	        }
	        return max;
	    }
}

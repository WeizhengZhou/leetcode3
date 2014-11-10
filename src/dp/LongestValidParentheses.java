package dp;

public class LongestValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestValidParentheses l=new LongestValidParentheses();
		System.out.println(l.longestValidP("("));

	}
	
	public int longestValidP(String s){
		if (s==null||s.equals("")){
			return 0;
		}
		int max=0;
		int[] len=new int[s.length()];
		
		for(int i=len.length-2;i>=0;i--){
			if (s.charAt(i)==')'){
				len[i]=0;
			}
			else{
				if(i+1>len.length){
					len[i]=0;
				}
				else if(s.charAt(i+1)==')'){
					len[i]=2;
					if(i+2<len.length){
						len[i]+=len[i+2];
					}
				}
				else{
					if(i+len[i+1]+1<len.length && s.charAt(i+len[i+1]+1)==')'){
						len[i]=len[i+1]+2;
						if(i+len[i+1]+2<len.length){
							len[i]+=len[i+len[i+1]+2];
						}
					}
				}				
			}
			max=Math.max(max, len[i]);
		}
		return max;
	}

}

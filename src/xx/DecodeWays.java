package xx;

public class DecodeWays {
	 public int numDecodings(String s) {
		    if(s==null ||s.length()==0)return 0;
		    int[] nWays=new int[s.length()+1];
		    nWays[0]=1;
		    nWays[1]=s.charAt(0)>'0'?1:0;
		    for(int i=2;i<=s.length();i++){
		        nWays[i]=s.charAt(i-1)>'0'?nWays[i-1]:0;
		        int twoDigits=Integer.parseInt(s.substring(i-2,i));
		        if(twoDigits>=10 && twoDigits<=26){
		            nWays[i]+=nWays[i-2];
		        }
		    }
		    return nWays[s.length()];
	    }
}

package dp;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0){
        	return "";
        }
        int d=Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++){
        	d=Math.min(d, strs[i].length());
        }
        if(d==0){
        	return "";
        }
        for(int l=0;l<d;l++){
        	char c=strs[0].charAt(l);
        	for(int i=0;i<strs.length;i++){
            	if(strs[i].charAt(l)!=c){
            		return strs[0].substring(0, l);
            	}
            }
        }
        return strs[0].substring(0, d);
    }

}

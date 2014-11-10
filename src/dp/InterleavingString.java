package dp;

public class InterleavingString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isInterleaving(String s1, String s2, String s3){
		if (s1==null||s2==null||s3==null){
			return false;
		}
		if(s1.length()+s2.length()!=s3.length()){
			return false;
		}
		return helper(s1,s2,s3,0,0);
	}
	
	public boolean helper(String s1, String s2, String s3, int i1, int i2){
		boolean isInterleaving=false;
		if(s1.charAt(i1)==s3.charAt(i1+i2)){
			isInterleaving=helper(s1,s2,s3,i1+1,i2);
		}
		if(!isInterleaving){
			if(s2.charAt(i2)==s3.charAt(i1+i2)){
				isInterleaving=helper(s1,s2,s3,i1,i2+1);
			}
		}
		return isInterleaving;
	}

}

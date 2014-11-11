package dp;

public class InterleavingString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterleavingString i=new InterleavingString();
		System.out.println(i.isInterleaving("aabcc", "dbbca", "aadbbcbcac"));

	}
	
	public boolean isInterleaving(String s1, String s2, String s3){
		if (s1==null||s2==null||s3==null){
			return false;
		}
		if(s1.length()+s2.length()!=s3.length()){
			return false;
		}
		int[][] check=new int[s1.length()][s2.length()];
		return helper(s1,s2,s3,0,0,check);
	}
	
	public boolean helper(String s1, String s2, String s3, int i1, int i2, int[][] c){
		if (i1>=s1.length()){
			return s2.substring(i2).equals(s3.substring(s1.length()+i2));
		}
		if(i2>=s2.length()){
			return s1.substring(i1).equals(s3.substring(i1+s2.length()));
		}
		if (c[i1][i2]!=0){
			return c[i1][i2]==1?true:false;
		}
		boolean isInterleaving=false;
		if(s1.charAt(i1)==s3.charAt(i1+i2)){
			isInterleaving=helper(s1,s2,s3,i1+1,i2,c);
		}
		if(!isInterleaving){
			if(s2.charAt(i2)==s3.charAt(i1+i2)){
				isInterleaving=helper(s1,s2,s3,i1,i2+1,c);
			}
		}
		c[i1][i2]=isInterleaving?1:-1;
		return isInterleaving;
	}
	
	

}

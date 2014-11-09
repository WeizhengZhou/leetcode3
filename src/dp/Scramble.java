package dp;

public class Scramble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scramble s=new Scramble();
		boolean b=s.isScramble("abcd", "bdca");
		System.out.println(b);

	}
	
	public boolean isScramble(String s1, String s2){
		int l=s1.length();
		int[][][] check=new int[l][l][l+1];
		for (int i=0;i<l;i++){
			for (int j=0;j<l;j++){
				for(int k=0;k<=l;k++){
					check[i][j][l]=0;
				}
			}
		}
		return helper(s1,0,s1.length(),s2,0,s2.length(), check);
	}
	
	public boolean helper(String s1, int l1, int r1, String s2, int l2, int r2,int[][][] c){
//		System.out.println("l1 = " + l1 + ", r1 = " + r1 + ", l2 = " + l2 + ", r2 = " + r2);
		if (l1>r1||l2>r2) {
			return false;
		}
		
		if (c[l1][l2][r1-l1]!=0){
			return c[l1][l2][r1-l1]==1?true:false;
		}
		if (s1.substring(l1,r1).equals(s2.substring(l2, r2))){
			
			c[l1][l2][r1-l1]=1;
			return true;
		}
		int length = r2-l2;
		for (int i=1; i<(r2-l2); i++){
//			if (helper(s1,l1,l1+i,s2,r2-i,r2,c)&&(helper(s1,r1-i,r1,s2,l2,l2+i,c))||(helper(s1,l1,l1+i,s2,l2,l2+i,c)&&helper(s1,l1+i,r1,s2,l2+i,r2,c)))
//			{
//				c[l1][l2][r1-l1]=1;
//				return true;
//			}
			if (helper(s1,l1,l1+i,s2,r2-i,r2,c)&&helper(s1,r1-(length-i),r1,s2,l2,l2+(length-i),c))
			{
				c[l1][l2][r1-l1]=1;
				return true;
			}
			if(helper(s1,l1,l1+i,s2,l2,l2+i,c)&&helper(s1,l1+i,r1,s2,l2+i,r2,c)){
				c[l1][l2][r1-l1]=1;
				return true;
			}
		}
		c[l1][l2][r1-l1]=-1;
		return false;
	}

}

package dp;

public class Scramble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scramble s=new Scramble();
		boolean b=s.isScramble("great", "rgtea");
		System.out.println(b);

	}
	
	public boolean isScramble(String s1, String s2){
		return helper(s1,0,s1.length(),s2,0,s2.length());
	}
	
	public boolean helper(String s1, int l1, int r1, String s2, int l2, int r2){
		if (l1>r1||l2>r2) return false;
		if (s1.substring(l1,r1).equals(s2.substring(l2, r2))){
			return true;
		}
		for (int i=l2+1; i<r2; i++){
			if ((helper(s1,l1,i,s2,l2,i)&&helper(s1,i,r1,s2,i,r2))||(helper(s1,r1-i+l2,r1,s2,l2,i)&&helper(s1,l1,l1+r2-i,s2,i,r2)))
			{
				return true;
			}
		}
		return false;
	}

}

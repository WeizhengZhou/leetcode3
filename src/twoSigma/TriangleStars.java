package twoSigma;

public class TriangleStars {
//	public void printStars(int n){
//		String s = buildStr(n);
//		System.out.println(s);		
//	}
//	public String buildStr(int n){
//		if(n == 1) return "*";
//		String s = buildStr(n-1);
//		String[] strs = s.split("\n");
//		return strs[0]+"*"+"\n"+s;
//	}	
	public void printStars(int n){
		helper(n,1,"*");		
	}
	private void helper(int n, int k, String t){
		if(k == n){
			System.out.println(t);
			return;
		}
		helper(n,k+1,t+"*");
		System.out.println(t);
	}
	public static void main(String[] args){
		TriangleStars solu = new TriangleStars();
		solu.printStars(5);		
	}
}

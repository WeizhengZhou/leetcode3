package dp;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EditDistance e=new EditDistance();
		System.out.println(e.editDistance("ab", "bc"));
		System.out.println('a'=='b');

	}
	
	public int editDistance(String word1, String word2){
		int[][] A=new int[word1.length()+1][word2.length()+1];
		for(int i=0; i<=word2.length();i++){
			A[0][i]=i;
		}
		for(int i=0; i<=word1.length();i++){
			A[i][0]=i;
		}
		for(int i=1; i<=word1.length();i++){
			for(int j=1;j<=word2.length();j++){
				if(word1.charAt(i-1)==word2.charAt(j-1)){
					A[i][j]=Math.min(Math.min(A[i-1][j],A[i][j-1])+1, A[i-1][j-1]);
				}
				else{
					A[i][j]=Math.min(Math.min(A[i-1][j],A[i][j-1])+1, A[i-1][j-1]+1);
				}
				System.out.println("A["+i+"]["+j+"]="+A[i][j]);
			}
		}
		return A[word1.length()][word2.length()];
	}

}

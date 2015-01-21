//zz reviewd
package zz;

public class MinDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minDistance(String word1, String word2) {
		//zz, special cases are wrong
		//zz, consider word1 = null, word2 = "a", their edit distance should be 1
        if(word1==null || word2==null ){
        	return 0;
        }
		//zz word1.length(), and word2.length() are frequently used later on, 
		//zz, using variable n = word1.length() can make code shorter,
		//zz, also, I think using n is more efficient, since word1.length() needs to refer memory
        int[][]  min=new int[word1.length()+1][word2.length()+1];//minimum distance
		//zz when looping the column, use variable "j", which is easier to read, and it can remind you it is a colum index
        for(int i=0;i<=word2.length();i++){
        	min[0][i]=i;
        }
		
        for(int i=0;i<=word1.length();i++){
        	min[i][0]=i;
        }
        for(int i=1;i<=word1.length();i++){
        	for(int j=1;j<=word2.length();j++){
        		int cur=Math.min(min[i-1][j], min[i][j-1])+1;
        		if(word1.charAt(i-1)==word2.charAt(j-1)){
        			min[i][j]=Math.min(cur, min[i-1][j-1]);
        		}
        		else{
        			min[i][j]=Math.min(cur, min[i-1][j-1]+1);
        		}
        	}
        }
        return min[word1.length()][word2.length()];
    }
}

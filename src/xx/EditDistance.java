package xx;

public class EditDistance {
	public int minDistance(String word1, String word2) {
        if(word1==null || word2==null)return 0;
        int[][] distance=new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<=word1.length();i++){
            distance[i][0]=i;
        }
        for(int j=0;j<=word2.length();j++){
            distance[0][j]=j;
        }
        for(int i=1;i<=word1.length();i++){
            for(int j=1;j<=word2.length();j++){
                int min=Math.min(distance[i-1][j],distance[i][j-1])+1;
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    min=Math.min(min,distance[i-1][j-1]);
                }
                else{
                    min=Math.min(min,distance[i-1][j-1]+1);
                }
                distance[i][j]=min;
            }
        }
        return distance[word1.length()][word2.length()];
    }
}

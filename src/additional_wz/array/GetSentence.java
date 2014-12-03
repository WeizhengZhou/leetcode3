package array;

import java.util.*;

public class GetSentence {
	public String getSentence(String text, Set<String> dict){
		if(text == null || dict == null) return "";
		
		int n = text.length();
		int[] dp = new int[n+1];
		for(int i=0;i<n;i++){
			int cut = -1;
			for(int j=0;j<=i;j++){
				if(dp[j] >=0 && dict.contains(text.substring(j,i+1)))
					cut = j;
			}
			dp[i+1] = cut;
		}
		System.out.println(Arrays.toString(dp));
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<text.length();i++){
			if(dp[i] > 0){
				sb.append(text.substring(i,dp[i]+1));
				if(dp[i] < text.length())
					sb.append(" ");
			}
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	public static void main(String[] args){
		Set<String> dict = new HashSet<>();
		dict.add("from");
		dict.add("China");
		dict.add("I");
		dict.add("You");
		dict.add("am");
		dict.add("are");
		String text =  "IamfromChina";
		GetSentence solu = new GetSentence();
		solu.getSentence(text, dict);
		
	}
}

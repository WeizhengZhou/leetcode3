package gogo;

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s==null || s.length()==0 || wordDict==null|| wordDict.size()==0) return false;
        boolean[] check = new boolean[s.length()+1];
        check[0] = true;
        for (int i=1;i<=s.length();i++) {
        	if (wordDict.contains(s.substring(0,i))) {
        		check[i] = true;
        		continue;
        	}
        	for (int j=1;j<i;j++){
        		if (check[j] && wordDict.contains(s.substring(j, i))) {
        			check[i] = true;
        			break;
        		}
        	}
        }
        return check[s.length()];       		
    }
}

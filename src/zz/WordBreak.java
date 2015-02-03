//zz reviewe
package zz;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> dict=new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		WordBreak w=new WordBreak();
		System.out.println(w.wordBreak("leetcode", dict));

	}
	
    public boolean wordBreak(String s, Set<String> dict) {
        if(s==null || s.length()==0){
        	return false;
        }
        boolean[] breakable=new boolean[s.length()+1];
        breakable[0]=true;
        for(int i=1;i<=s.length();i++){
        	for(int j=0;j<i;j++){
        		if(breakable[j] && dict.contains(s.substring(j, i))){
        			breakable[i]=true;
        		}
        	}
        }
        System.out.println(Arrays.toString(breakable));
        return breakable[s.length()];
    }

}

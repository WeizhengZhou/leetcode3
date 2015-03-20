package xx;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
		if(s==null || s.length()==0){return false;}
		boolean[] breakable=new boolean[s.length()+1];
		breakable[0]=true;
		for(int end=1;end<=s.length();end++){
			for(int start=0;start<end;start++){
				String sub=s.substring(start,end);
				if(dict.contains(sub)&&breakable[start]){
					breakable[end]=true;
					break;
				}
			}

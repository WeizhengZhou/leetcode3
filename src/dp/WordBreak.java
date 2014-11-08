package dp;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	public boolean Wordbreak(String s, Set<String> dict){
		if(s == null || dict == null) return false;
		
		int[] breakable = new int[s.length()];
		for(int i=0;i<breakable.length;i++){
			breakable[i]=0;
		}
		return Helper(s,0,dict,breakable)==1?true:false;
	}
	public int Helper(String s, int index, Set<String> dict,int[] breakable){
		if (breakable[index]!=0) return breakable[index];
		if (index==s.length()) {
			breakable[index]=1;
			return 1;
		}
		
		String Sub=s.substring(index);
		if (dict.contains(Sub)){
			breakable[index]=1;
			return 1;
		}
		for (int i=index+1;i<=s.length();i++){
			String text=s.substring(index, i);
			if (dict.contains(text)){
				if (Helper(s,i,dict,breakable)==1){
					breakable[index]=1;
					return 1;
				}
				
			}
		}
		breakable[index]=-1;
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordBreak w=new WordBreak();
		Set<String> dict=new HashSet<String>();
		dict.add("aaaa");
		dict.add("aa");
		boolean b=w.Wordbreak("aaaaaaa", dict);
		System.out.println(b);
		System.out.println("aaaaaaa".substring(5));
	}
}

package zz;

import java.util.HashMap;
import java.util.Map;

public class MinWIndow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String minWindow(String S, String T) {
		if(S==null || S.length()==0 || T==null || T.length()==0 || S.length()<T.length()){
			return "";
		}
		Map<Character,Integer> map=new HashMap<Character,Integer>();
		for(int i=0;i<T.length();i++){
			if(!map.containsKey(T.charAt(i))){
				map.put(T.charAt(i), 1);
			}
			else{
				map.put(T.charAt(i), map.get(T.charAt(i))+1);
			}
		}
		int count=0;
		int start=0;
		String min=S;
		for(int i=0;i<S.length();i++){
			char cur=S.charAt(i);
			if(count<T.length()){
				if(map.containsKey(cur)){
					if(map.get(cur)>0){
						count++;
					}
					//map.put(cur, map.get(cur)-1);
				}
			}
			if(map.containsKey(cur)){
				map.put(cur, map.get(cur)-1);
			}
			if(count==T.length())
			{
				if(map.containsKey(cur)){
					//map.put(cur, map.get(cur)-1);				
					while(start<=i && (!map.containsKey(S.charAt(start))||map.containsKey(S.charAt(start))&& map.get(S.charAt(start))<0)){
						if(map.containsKey(S.charAt(start))){
							map.put(S.charAt(start), map.get(S.charAt(start))+1);
						}
						start++;
					}
				}
				if(i-start+1<min.length()){
					min=S.substring(start,i+1);
				}
			}
		}
		return count==T.length()?min:"";
	}

}

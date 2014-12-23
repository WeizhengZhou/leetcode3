package additional;

import java.util.HashMap;
import java.util.Map;

public class LongSubTwoChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongSubTwoChar l=new LongSubTwoChar();
		System.out.println(l.getSubstring("adssdgaddfa"));
	}
	
	class Pair{
		int s;
		int e;
		Pair(int x, int y){
			s=x;
			e=y;
		}
	}
	public String getSubstring(String S){
		if(S==null || S.length()<=1){
			return "";
		}
		int start=0;
		int end=0;
		int max=0;
		Pair sub=new Pair(0,0);
		Map<Character,Pair> map=new HashMap<Character,Pair>();
		for(int i=0;i<S.length();i++){
			char c=S.charAt(i);
			if(map.containsKey(c)){
				Pair p=map.get(c);
				p.e=i;
				map.put(c, p);
				end=i;
				if(end-start+1>max){
					sub.s=start;
					sub.e=end;
					max=end-start+1;
				}
			}
			else{
				if(map.size()<2){
					map.put(c, new Pair(i,i));
					end=i;
					if(end-start+1>max){
						sub.s=start;
						sub.e=end;
					}
				}
				else{
					char b=' ';
					int j=S.length();
					for(char temp:map.keySet()){
						if(map.get(temp).s<j){
							b=temp;
							j=map.get(temp).s;
						}
					}
					start=map.get(b).e+1;
					//System.out.println("new start="+start);
					map.remove(b);
					map.put(c, new Pair(i,i));
				}
			}
		}
		return S.substring(sub.s, sub.e+1);
	}

}

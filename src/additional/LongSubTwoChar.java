package additional;

import java.util.HashMap;
import java.util.Map;

public class LongSubTwoChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
			
		}
		return "";
	}

}

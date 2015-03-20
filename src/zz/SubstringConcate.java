//zz reviewed

package zz;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SubstringConcate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubstringConcate s=new SubstringConcate();
		System.out.println(s.findSubstring("barfoothefoobarman", new String[]{"foo","bar"}));

	}
	
	public List<Integer> findSubstring(String S, String[] L) {
		List<Integer> res=new LinkedList<Integer>();
		if(S==null || S.length()==0 || L==null || L.length==0){
			return res;
		}
		int len=L[0].length();
		int totalLen=len*L.length;		
		for(int i=0;i<S.length()-totalLen+1;i++){
			Map<String,Integer> map=buildMap(L);
			int count=L.length;
			for(int j=i;j<i+totalLen;j+=len){
				String sub=S.substring(j,j+len);
				System.out.println(sub);
				if(!map.containsKey(sub)||map.get(sub)<=0){
					break;
				}
				else{
					map.put(sub, map.get(sub)-1);
					count--;
				}
			}
			System.out.println("");
			if(count==0){
				res.add(i);
			}
		}
		return res;
	}
	
	public Map<String,Integer> buildMap(String[] L){
		Map<String,Integer> map=new HashMap<>();
		for(String s:L){
			if(!map.containsKey(s)){
				map.put(s, 1);
			}
			else{
				map.put(s, map.get(s)+1);
			}
		}
		return map;
	}
}

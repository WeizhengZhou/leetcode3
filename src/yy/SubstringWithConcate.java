import java.util.*;
public class SubstringWithConcate{
	public static void main(String[] args){
		SubstringWithConcate s=new SubstringWithConcate();
//System.out.println("ok!");
		System.out.println(s.findSubstring("barfoothefoobarman", new String[]{"foo","bar"}).toString());
	}
	public List<Integer> findSubstring(String S, String[] L) {
		List<Integer> res=new LinkedList<>();
		if(S==null || S.length()==0 || L==null || L.length==0){
			return res;
		}		
		int arraySize=L.length;
		int wordSize=L[0].length();
		int totalSize=arraySize*wordSize;
		Map<String,Integer> map=new HashMap<>();
		for(int i=0;i<arraySize;i++){
			if(map.containsKey(L[i])){
				map.put(L[i],map.get(L[i])+1);
			}
			else{
				map.put(L[i],1);
    			}
		}
		for(int i=0;i<=S.length()-totalSize;i++){
			Map<String,Integer> hash=new HashMap<String,Integer>(map);
			//System.out.println(hash.size());
			for(int j=i;j<i+totalSize;j+=wordSize){
				String word=S.substring(j,j+wordSize);
				if(!hash.containsKey(word)||hash.get(word)<=0){
					break;
				}
				hash.put(word,hash.get(word)-1);
				if(j==i+totalSize-wordSize)res.add(i);
			}	
		}
		return res;
	}
}

package dp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SubstringConcatAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubstringConcatAll s=new SubstringConcatAll ();
		System.out.println(s.findSubstring("aaa", new String[]{"aa","aa"}));
		//System.out.println("abd".su)
	}
	
    public List<Integer> findSubstring(String S, String[] L) {
    	List<Integer> res=new LinkedList<Integer>();
    	if(S==null||S.length()==0){
    		return res;
    	}
    	int len=L[0].length();
    	int count=L.length;
    	for(int i=0;i<len;i++){
    		Map<String,Integer> map=buildMap(L);
    		int l=i;
    		int r=l;
    		while(l<S.length()&&r+len<=S.length()){
    			String sub=S.substring(r, r+len);
    			//System.out.println(sub);
    			if(map.containsKey(sub)){
    				if(map.get(sub)>0){
    					System.out.println("l:"+l+",r="+r+" (matched)");
    					System.out.println("substring="+sub);
    					System.out.println("count="+count);
    					int nums=map.get(sub);
    					map.put(sub, nums-1);
    					System.out.println("#of SubString="+map.get(sub));
    					count--;
    					r=r+len;
    					System.out.println("l:"+l+",r="+r+" (matched)");
    					System.out.println(count);
    				}    				
    				if(count==0){
    					res.add(l);
    					System.out.println(res);
    					String add=S.substring(l, l+len);
    					map.put(add, map.get(add)+1);
    					count++;
    					l=l+len;    					
    					System.out.println("l:"+l+",r="+r+" (count==0)");
    				}
    				if(map.get(sub)<=0){
    					for(int k=l;k<r;k=k+len){
        					String addS=S.substring(k, k+len);
        					System.out.println(addS);
        					map.put(addS, map.get(addS)+1);    					
        				}
        				r=r+len;
        				l=r;
    					count=L.length;
    				}
    				
    			}
    			else{
    				System.out.println("l:"+l+",r="+r+" (not match)");
    				for(int k=l;k<r;k=k+len){
    					String addS=S.substring(k, k+len);
    					System.out.println(addS);
    					map.put(addS, map.get(addS)+1);    					
    				}
    				r=r+len;
    				l=r;
					count=L.length;
					System.out.println("l:"+l+",r="+r+" (not match)");
    			}
    		}
    	}
    	return res;
    }
    
    public Map<String,Integer> buildMap(String[] L){
    	Map<String, Integer> map=new HashMap<String,Integer>();
    	for(int i=0;i<L.length;i++){
    		if(!map.containsKey(L[i])){
    			map.put(L[i], 1);
    		}
    		else{
    			map.put(L[i], map.get(L[i])+1);
    		}
    	}
    	return map;
    }

}

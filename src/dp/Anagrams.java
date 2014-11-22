package dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Anagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Anagrams a=new Anagrams();
		System.out.println(a.anagrams(new String[]{"inc","cou","cou"}));

	}
    public List<String> anagrams(String[] strs) {
    	List<String> res=new LinkedList<String>();
    	if(strs==null||strs.length==0){
    		return res;
    	}
    	Arrays.sort(strs, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				char[] c1=o1.toCharArray();
				char[] c2=o2.toCharArray();
				return c1.toString().compareTo(c2.toString());
			}   		
    	});
    	String pre="";
    	int count=0;
    	for(int i=0; i<strs.length;i++){
    		if (!strs[i].equals(pre)){
    			if(count>0)
    			{
    				res.add(pre);    				
    			}
    			pre=strs[i];
    			count=0;
    		}
    		else{
    			count++;
    		}
    	}
    	if(count>0)
		{
			res.add(pre);    				
		}
    	return res;
    }
}

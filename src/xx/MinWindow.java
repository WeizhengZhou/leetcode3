package xx;

import java.util.*;

public class MinWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinWindow m=new MinWindow();
		System.out.println(m.minWindow("bba", "ab"));
	}
    public String minWindow(String S, String T) {
		if(S==null || T==null || S.length()<T.length())return "";
		int count=T.length();
		Map<Character,Integer> map=new HashMap<>();
		for(int i=0;i<count;i++){
		    char c=T.charAt(i);
		    if(!map.containsKey(c)){map.put(c,1);}
		    else{
		        map.put(c,map.get(c)+1);
		    }
		    System.out.println(map.get(c));
		}
		int start=0;
		String res="";
		int len=Integer.MAX_VALUE;
		for(int i=0;i<S.length();i++){
		    char cur=S.charAt(i);
		    if(!map.containsKey(cur)){continue;}
		    int times=map.get(cur);
		    if(times>0){count--;}
		    map.put(cur,times-1);
		    if(count==0){
		        char s=S.charAt(start);
		        System.out.println(s);
		        System.out.println(start);
		        System.out.println("i="+i);
		        while(start<i && (!map.containsKey(s) || map.get(s)<0 )){
		            if(map.containsKey(s))
                    {
                        map.put(s,map.get(S.charAt(start)+1));
                    }
		            start++;
		            s=S.charAt(start);
		            System.out.println("in s="+s);
			        System.out.println("in start="+start);
			        System.out.println(map.containsKey(s));
			        System.out.println(map.get(s));
		        }
		        if(i-start+1<len){res=S.substring(start,i+1);}
		    } 
		}
		return res;
    }
}

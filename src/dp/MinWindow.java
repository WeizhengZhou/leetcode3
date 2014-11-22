package dp;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinWindow m=new MinWindow();
		System.out.println(m.minWindow("acbbaca", "aba"));
	}
    public String minWindow(String S, String T) {
        if (S==null||S.length()==0||T==null||T.length()==0){
        	return "";
        }
        Map<String, Integer> map=new HashMap<String,Integer>();
        for(int i=0;i<T.length();i++){
        	if(!map.containsKey(T.substring(i, i+1))){
        		map.put(T.substring(i,i+1), 1);
        	}
        	else{
        		map.put(T.substring(i,i+1), map.get(T.substring(i,i+1))+1);
        	}
        }
        int count=T.length();
        int l=0;
        int last=0;
        String min=S;
        for(int i=0;i<S.length();i++){
        	String s=S.substring(i, i+1);
        	
        	if(count>0&&map.containsKey(s)&&map.get(s)>0){
        		last=count;
        		count--; 
        		
        	} 
        	if(last>0&&map.containsKey(s)){
        		map.put(s, map.get(s)-1);
        	}
        	if(count==0){
        		if(map.containsKey(s)){
        			System.out.println("s="+s+",map.get="+(map.get(s)-1)+",l="+l);
        			if(last==0)
        			{
        				map.put(s, map.get(s)-1);
        			}
        			last=0;
        			while(l<=i && (!map.containsKey(S.substring(l, l+1))||map.get(S.substring(l, l+1))<0)){        				
        				if(map.containsKey(S.substring(l, l+1))){
        					map.put(S.substring(l, l+1), map.get(S.substring(l, l+1))+1);
        				}
        				l++;
        				System.out.println("l="+l+",i="+i);
        			}
        			if(Math.abs(i-l+1)<min.length()){
        				min=S.substring(l, i+1);
        				System.out.println(min);
        			}
        		}
        		
        	}
        }
        return count==0?min:"";
    }
}

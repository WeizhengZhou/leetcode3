package dp;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int romanToInt(String s) {
        if (s==null||s.length()==0){
        	return 0;
        }
        Map<String,Integer> dict=new HashMap<String,Integer>();
        dict.put("I", 1);
        dict.put("V", 5);
        dict.put("X", 10);
        dict.put("L", 50);
        dict.put("C", 100);
        dict.put("D", 500);
        dict.put("M", 1000);
        int pre=0;
        int sum=0;
        for(int i=s.length()-1;i>=0;i--){
        	String r=s.substring(i,i+1);
        	if(!dict.containsKey(r)){
        		return 0;
        	}
        	int d=dict.get(r);
        	if(d<pre){
        		sum-=d;
        	}
        	else{
        		sum+=d;
        	}
        	pre=d;
        }
        return sum;
    }
}

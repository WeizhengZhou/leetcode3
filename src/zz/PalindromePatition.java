package zz;

import java.util.LinkedList;
import java.util.List;

public class PalindromePatition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<List<String>> partition(String s) {
        List<List<String>> res=new LinkedList<List<String>>();
        if(s==null || s.length()==0){
        	return res;
        }
        boolean[][] isPa=new boolean[s.length()][s.length()];
        isPa[0][0]=true;
        for(int i=1;i<s.length();i++){
        	isPa[i][i]=true;
        	if(s.charAt(i-1)==s.charAt(i)){
        		isPa[i-1][i]=true;
        	}
        }
        for(int d=2;d<s.length();d++){
        	for(int i=0;i<s.length()-d;i++){
        		int j=i+d;
        		if(isPa[i+1][j-1] && s.charAt(i)==s.charAt(j)){
        			isPa[i][j]=true;
        		}
        	}
        }
        helper(0,s,isPa,res,new LinkedList<String>());
        return res;
    }
    
    public void helper(int start, String s, boolean[][] isPa, List<List<String>> res, List<String> list){
    	if(start>=s.length()){
    		res.add(new LinkedList<String>(list));
    		return;
    	}
    	for(int i=start; i<s.length();i++){
    		if(isPa[start][i]){
    			list.add(s.substring(start,i+1));
    			helper(i+1,s,isPa,res,list);
    			list.remove(list.size()-1);
    		}
    	}
    }

}

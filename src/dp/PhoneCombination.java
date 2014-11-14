package dp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PhoneCombination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> letterCom(String digits){
		Map<Integer,String> dict=new HashMap<Integer,String>();
		dict.put(2,"abc");
		dict.put(3,"def");
		dict.put(4,"ghi");
		dict.put(5,"jkl");
		dict.put(6,"mno");
		dict.put(7,"pqrs");
		dict.put(8,"tuv");
		dict.put(9,"wxyz");
		List<String> res=new LinkedList<String>();
		helper(digits,0,dict,res,new StringBuilder());
		return res;
	}
	
	public void helper(String s, int index, Map<Integer,String> dict,List<String> res, StringBuilder sb){
		if(index>=s.length()){
			res.add(sb.toString());
			return;
		}
		int digit=Integer.parseInt(s.substring(index, index+1));
		String letters=dict.get(digit);
		for(int i=0;i<letters.length();i++){
			sb.append(letters.charAt(i));
			helper(s,index+1,dict,res,sb);
			sb.deleteCharAt(sb.length()-1);
		}
	}

}

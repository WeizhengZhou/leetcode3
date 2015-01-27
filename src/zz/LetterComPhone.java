package zz;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterComPhone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public List<String> letterCombinations(String digits) {
		 List<String> res=new LinkedList<>();
		 if(digits==null || digits.length()==0){
			 res.add("");
			 return res;
		 }
		 Map<Character,String> map=new HashMap<>();
		 map.put('2', "abc");
		 map.put('3', "def");
		 map.put('4', "ghi");
		 map.put('5', "jkl");
		 map.put('6', "mno");
		 map.put('7', "pqrs");
		 map.put('8', "tuv");
		 map.put('9', "wxyz");
		 helper(0,new char[digits.length()],digits,map,res);
		 return res;
	 }
	 
	 public void helper(int index,char[] buf, String digits, Map<Character,String> map, List<String> res){
		 if(index==digits.length()){
			 res.add(new String(buf));
			 return;
		 }
		 String cur=map.get(digits.charAt(index));
		 for(int i=0;i<cur.length();i++){
			 buf[index]=cur.charAt(i);
			 helper(index+1,buf,digits,map,res);
		 }
	 }

}

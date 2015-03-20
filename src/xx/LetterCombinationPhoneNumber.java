package xx;
import java.util.*;
public class LetterCombinationPhoneNumber {
	public List<String> letterCombinations(String digits) {
		 List<String> res=new LinkedList<>();
		 if(digits==null || digits.length()==0){res.add("");return res;}
		 Map<Character,String> map=new HashMap<>();
		 map.put('2',"abc");
		 map.put('3',"def");
		 map.put('4',"ghi");
		 map.put('5',"jkl");
		 map.put('6',"mno");
		 map.put('7',"pqrs");
		 map.put('8',"tuv");
		 map.put('9',"wxyz");
		 helper(0,digits,map,res,new char[digits.length()]);
		 return res;
	 }
	 
	 private void helper(int index,String digits,Map<Character,String> map,List<String> res,char[] charA){
	     if(index==digits.length()){
	         res.add(new String(charA));
	         return;
	     }
	     char c=digits.charAt(index);
	     String characterBuf=map.get(c);
	     for(int i=0;i<characterBuf.length();i++){
	         charA[index]=characterBuf.charAt(i);
	         helper(index+1,digits,map,res,charA);
	     }
	 }
}

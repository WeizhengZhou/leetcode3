package gogo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinationPhone {
	private static Map<Character, String> map;
	
	public LetterCombinationPhone() {
		map = new HashMap<> ();
		map.put('2',"abc");
		map.put('3',"def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
	}
	
	
	public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0 ) return null; 
        return combineHelper(0, digits);
    }
	
	private List<String> combineHelper(int index, String digits) {
		List<String> re = new LinkedList<> ();
		if (index >= digits.length()) {
			re.add("");
			return re;
		}
		String letters = map.get(digits.charAt(index));
		List<String> combines = combineHelper(index+1,digits);
		for (int i = 0; i<letters.length(); i++) {
			char c= letters.charAt(i);
			for (int j=0; j<combines.size();j++) {
				re.add( c + combines.get(j) );
			}
		}
		return re;
	}
}

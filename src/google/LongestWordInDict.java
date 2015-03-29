import java.util.*;
public class LongestWordInDict {
	public void longestWord(List<String> dict, List<Character> letters){
		int[] freq = new int[26];
		for(Character c : letters){
			int index = (int) (c-'a');
			freq[index] = freq[index]+1;
		}
		System.out.println(Arrays.toString(freq));
		String max_word = null;
		int max_len = 0;
		for(String s:dict){
			s = s.toLowerCase();
			boolean canBeContructed = helper(s, Arrays.copyOf(freq, freq.length));
			if(canBeContructed && s.length() > max_len){
				max_len = s.length();
				max_word = s;
			}
		}
		System.out.println(max_word);
	}
	private boolean helper(String s, int[] freq){
		boolean flag = true;
		for(int i=0;i<s.length();i++){
			freq[s.charAt(i) - 'a'] -= 1;
			if(freq[s.charAt(i) - 'a'] < 0)
				return false;
		}
		return true;
	}
	public static void main(String[] args){
		List<Character> letters = new ArrayList<>();
		letters.add('a');
		letters.add('e');
		letters.add('f');
		letters.add('f');
		letters.add('g');
		letters.add('i');
		letters.add('r');
		letters.add('q');
		List<String> dict = new ArrayList<>();
		dict.add("gaff");
		dict.add("giraffe");
		dict.add("aeffgirq");
		new LongestWordInDict().longestWord(dict, letters);		
	}
}

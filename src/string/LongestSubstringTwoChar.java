package string;

import java.util.Deque;
import java.util.LinkedList;

public class LongestSubstringTwoChar{
	public int compute(String s){
		if(s == null) return 0;
 		if(s.length() <= 2) return s.length();
		Deque<Integer> q1 = new LinkedList<>();
		Deque<Integer> q2 = new LinkedList<>();
		q1.addLast(0);
		return 0;
	}
}

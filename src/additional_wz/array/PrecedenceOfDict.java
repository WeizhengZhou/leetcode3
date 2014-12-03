package array;
import java.util.*;
public class PrecedenceOfDict {
	public List<Character> getPrecedence(List<String> dict){
		return helper(dict,0,dict.size()-1);	
	}
	private List<Character> helper(List<String> dict, int l, int r){
		if(l<0 || r>dict.size() || l>r) return null;
		String leftStr = dict.get(l);
		String rightStr = dict.get(r);
		if(l == r || leftStr.charAt(0) == rightStr.charAt(0)){
			List<Character> list = new ArrayList<>();
			list.add(leftStr.charAt(0));
			return list;
		}
		int m = l + (r-l)/2;
		List<Character> leftSeq = helper(dict,l,m);
		List<Character> rightSeq = helper(dict,m+1,r);
		if(leftSeq == null) return rightSeq;
		if(rightSeq == null) return leftSeq;
		if(leftSeq.get(leftSeq.size()-1) == rightSeq.get(0))
			leftSeq.remove(leftSeq.size()-1);
		leftSeq.addAll(rightSeq);
		return leftSeq;
	}
	public static void main(String[] args){
		List<String> dict = new ArrayList<>();
		dict.add("ze");
		dict.add("bb");
		dict.add("r");
		dict.add("mz");
		dict.add("mb");
		dict.add("mr");
		dict.add("e");
		List<Character> seq = new PrecedenceOfDict().getPrecedence(dict);
		System.out.println(seq);
		
	}

}

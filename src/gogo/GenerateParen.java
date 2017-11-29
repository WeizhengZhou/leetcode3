package gogo;

import java.util.LinkedList;
import java.util.List;

public class GenerateParen {
	public List<String> generateParenthesis(int n) {
        List<String> re = new LinkedList<> ();
        if (n<=0) return re;
        char[] chars = new char[n*2];
        helper(0,n,n,n,chars,re);
        return re;
    }
	
	private void helper(int index, int l, int r, int limit, char[] builder, List<String> list) {
		if (index > limit) {list.add(new String(builder)); return;}
		if (l<=r && l>0) {
			builder[index] = '(';
			helper(index + 1, l-1, r, limit, builder, list);
		}
		if (l<r && r>0) {
			builder[index] = ')';
			helper(index+1, l, r-1, limit, builder, list);
		}
	}
}

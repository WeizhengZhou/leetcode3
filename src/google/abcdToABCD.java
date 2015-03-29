import java.util.*;

public class abcdToABCD {
	public static void main(String[] args){
		String s = "abc";
		List<String> res = new ArrayList<>();
		for(int i=0;i<(int) Math.pow(2,s.length());i++){
			StringBuilder sb = new StringBuilder();
			for(int j=0;j<s.length();j++){
				if((i & (1<<j)) !=0){
					sb.append(Character.toUpperCase(s.charAt(j)));
				}
				else{
					sb.append(s.charAt(j));
				}
			}
			res.add(sb.toString());
		}
		System.out.println(res);
	}

}

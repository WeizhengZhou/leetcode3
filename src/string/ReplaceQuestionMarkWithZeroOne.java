package string;

import java.util.*;
public class ReplaceQuestionMarkWithZeroOne{
	public List<String> replace(String s){
		if(s == null) return new ArrayList<String>();

		//count the total number of question mark
		int questionCount = 0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i) == '?')
				questionCount++;
		}
		
		List<String> res = new ArrayList<String>();
		if(questionCount == 0){//no question mark to replace 
			res.add(s);
			return res;
		}
		//for n question marks, there are 2^n permutations of result
		for(int i=0;i< (int) Math.pow(2,questionCount);i++){//repalce all question marks with 0 with 1, depending on the binary string of i, i = [0, 2^n-1]
			int index = 0;
			StringBuilder sb = new StringBuilder();
			for(int j=0;j<s.length();j++){
				if(s.charAt(j) == '?'){
					if((i & (1<<index)) == 0) //the index question mark is repaced by 0
						sb.append("0");
					else 
					    sb.append("1");
					index++;
				}
				else
					sb.append(s.substring(j,j+1));
			}	
			res.add(sb.toString());
		}
		return res;
	}
	public static void main(String[] args){
		String s = "a?b?c?";
		ReplaceQuestionMarkWithZeroOne solu = new ReplaceQuestionMarkWithZeroOne();
		List<String> res = solu.replace(s);
		System.out.println(res);
		
		
	}
}

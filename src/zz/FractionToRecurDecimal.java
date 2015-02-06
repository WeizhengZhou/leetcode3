package zz;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String fractionToDecimal(int numerator, int denominator) {
		if(denominator==0){
			return "";
		}
		if(numerator==0){
			return "0";
		}
		boolean isPos=numerator>=0&&denominator>0||numerator<0&&denominator<0?true:false;
		long numeratorL=numerator;
		long denominatorL=denominator;
		numeratorL=Math.abs(numeratorL);
		denominatorL=Math.abs(denominatorL);
		long integerPart=numeratorL/denominatorL;
		long remain=numeratorL%denominatorL;		
		if(remain==0){
			if(isPos)
			{
				return integerPart+"";
			}
			else{
				return "-"+integerPart+"";
			}
		}
		
		Map<Long,Integer> map=new HashMap<>();
		map.put(remain, 0);
		StringBuilder sb=new StringBuilder();
		int index=1;
		while(remain!=0){
			long curNumerator=remain*10;
			long curResultDigit=curNumerator/denominatorL;
			remain=curNumerator%denominatorL;
			sb.append(curResultDigit);
			if(remain==0){
				break;
			}
			if(map.containsKey(remain)){
				String recurringPart=sb.substring(map.get(remain));
				String nonRecurringPart=sb.substring(0,map.get(remain));
				String res= integerPart+"."+nonRecurringPart+"("+recurringPart+")";
				if (isPos){
					return res;
				}
				else{
					return "-"+res;
				}
			}
			else{
				map.put(remain,index++);
			}
		}
		String res= integerPart+"."+sb.toString();
		if (isPos){
			return res;
		}
		else{
			return "-"+res;
		}
	}
	
}

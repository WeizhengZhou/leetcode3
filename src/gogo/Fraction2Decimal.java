package gogo;

import java.util.HashMap;
import java.util.Map;

public class Fraction2Decimal {
	public static void main(String[] args) {
		//System.out.println(-10%Integer.MIN_VALUE);
		Fraction2Decimal f = new Fraction2Decimal();
		System.out.println(f.fractionToDecimal(Integer.MIN_VALUE,-1));
	}
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator==0||denominator==0) return "0";
        StringBuilder sb=new StringBuilder();
        long n=numerator;
        long main = n/denominator;
        System.out.println(main);
        if (main==0) {
        	if (numerator<0 && denominator>0 || numerator>0 && denominator<0){
        		sb.append('-');
        	}
        }
        sb.append(main);
        long remain = -Math.abs(numerator % denominator);
        denominator = -Math.abs(denominator);
        if (remain==0) return sb.toString();
        sb.append('.');
        StringBuilder r = new StringBuilder();
        Map<Long, Integer> map = new HashMap<> ();
        int i=0;
        map.put(remain, i++);    System.out.println(remain);   
        while (remain != 0) {System.out.println(remain);  
        	remain=remain*10;
        	r.append(remain/(denominator));
        	remain=remain%(denominator);
        	if (!map.containsKey(remain)) {
        		map.put(remain, i);
        	} else {
        		int start=map.get(remain);
        		String s=r.toString();
        		sb.append(s.substring(0,start));
        		sb.append('(');
        		sb.append(s.substring(start,i));
        		sb.append(')');
        		return sb.toString();
        	}
        	i++;
        }
        sb.append(r);
        return sb.toString();
    }
}

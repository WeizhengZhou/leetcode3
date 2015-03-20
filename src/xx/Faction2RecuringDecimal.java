package xx;

public class Faction2RecuringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
		if(denominator==0)return "";
		if(numerator==0)return "0";
		boolean isPo=numerator>0&&denominator>0||numerator<0&&denominator<0;
		long num=(long)numerator;
		long de=(long)denominator;
		num=Math.abs(num);
		de=Math.abs(de);
		long intPart=num/de;
		num=num%de;
		if(num==0){return isPo?String.valueOf(intPart):"-"+String.valueOf(intPart);}
		StringBuilder fracPart=new StringBuilder();
		Map<Long,Integer> map=new HashMap<>();
		map.put(num,0);
		int index=1;
		while(num!=0){
			num*=10;
			long digit=num/de;
			num=num%de;
			fracPart.append(digit);
			if(!map.containsKey(num)){map.put(num,index++);}
			else{
				int recurStartIndex=map.get(num);
				String recur=fracPart.substring(recurStartIndex,index);
				String nonRecur=fracPart.substring(0,recurStartIndex);
				String buf=String.valueOf(intPart)+"."+nonRecur+"("+recur+")";
				return isPo?buf:"-"+buf;
			}
		}
		String res= String.valueOf(intPart)+"."+fracPart.toString();
		return isPo?res:"-"+res;
	}
}

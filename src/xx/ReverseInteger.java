package xx;

public class ReverseInteger {
	public int reverse(int x) {
		long longX=x;
		boolean isPos=longX>0?true:false;
		long absX=Math.abs(longX);
		long reverse=0;
		while(absX!=0){
			long digit=absX%10;
			absX=absX/10;
			reverse=reverse*10+digit;
		}
		if(isPos && reverse>Integer.MAX_VALUE || !isPos && -reverse<Integer.MIN_VALUE){
			return 0;
		}
		int res=(int)reverse;
		return isPos?res:-res;

	}
}

package zz;

public class ReverseInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int reverse(int x) {
		if(x==0){
			return 0;
		}
		boolean isPos=x>0?true:false;
		int absX=Math.abs(x);
		int res=0;
		while(x>0){
			int cur=x%10;
			if(isPos){
				if(res<(Integer.MAX_VALUE-cur)/10)
				{
					res=10*res+cur;
				}
				else{
					return 0;
				}
			}
			else if(!isPos){
				if(res>(Integer.MIN_VALUE+cur)/10)
				{
					res=10*res-cur;
				}
				else{
					return 0;
				}
			}
			absX=absX/10;
		}
		return res;
	}

}

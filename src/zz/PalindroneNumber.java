//zz reviewed

package zz;

public class PalindroneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindroneNumber p=new PalindroneNumber();
		System.out.println(p.isPalindrome(10000001));
	}
	//zz if extra space allowed?
	/*
        public boolean isPalindrome_2(int x){
		if(x == Integer.MIN_VALUE)	return false;
		x = Math.abs(x);
		String s = x + "";	
		String r = new StringBuilder(s).reverse().toString();
		if(s.equals(r)) return true;
		else return false;
	}
       */
	public boolean isPalindrome(int x){
		if(x<0){
			return false;
		}
		int multi=1;
		while(x/multi/10>0){
			multi*=10;
		}
		multi=multi/10;
		int remain=x;
		while(x>0 && multi>=10){
			int last=remain%10;
			int first=remain/multi;
			if(last!=first){
				return false;
			}
			remain=remain%multi;
			remain=remain/10;
			multi=multi/100;
		}
		return true;
	}
	

}

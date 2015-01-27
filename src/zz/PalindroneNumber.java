package zz;

public class PalindroneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindroneNumber p=new PalindroneNumber();
		System.out.println(p.isPalindrome(10000001));
	}
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

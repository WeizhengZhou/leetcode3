package gogo;

public class AddDigits {
	public static void main(String[] args) {
		System.out.println(Integer.toString(-5, 2));
		System.out.println(5&5);
	}
    public int addDigits(int num) {
        int sum=num;
        while(sum>=10) {
        	sum=0;
        	while(num>0){
        		sum+=num%10;
        		num=num/10;
        	}
        	num=sum;
        }
        return sum;
    }
}

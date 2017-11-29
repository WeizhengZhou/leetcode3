package additional;

public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        int and=a&b;
        int xor=a^b;
        while(and>0 && xor>0) {
        	and=and<<1;
        	int temp=and;
        	and=and&xor;
        	xor=temp^xor;
        }
        return and>0 ? and : xor;
    }
}

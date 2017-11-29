
public class BitTest {
	public int swapBit(int x, int i, int j){
		if((x & (1<<i)) != (x & (1<<j))){
			x = flip(x,i);
			x = flip(x,j);
		}
		return x;
	}
	private int flip(int x, int d){
		System.out.println("x = " + x + ", d = " + d);
		if((x & (1<<d)) != 0){
			System.out.println("Set");
			x = x ^ (1 << d);
		}
		else{
			System.out.println("NOT Set");
			x = x | (1<<d);
		}
		return x;
	}
	public int reverseBits(int x){
		System.out.println(Integer.toBinaryString(x));
		
		x = ((x & 0xFFFF0000) >> 16) | ((x & 0x0000FFFF) << 16);
		System.out.println(Integer.toBinaryString(x));
		
		x = ((x & 0xFF00FF00) >> 8)  | ((x & 0x00FF00FF) << 8);
		System.out.println(Integer.toBinaryString(x));
		
		x = ((x & 0xF0F0F0F0) >> 4) | ((x & 0x0F0F0F0F) << 4);
		System.out.println(Integer.toBinaryString(x));
		
		x = ((x & 0xA0A0A0A0) >> 2) | ((x & 0x05050505) << 2);
		System.out.println(Integer.toBinaryString(x));
		
		return x;
		
	}
	public int countSetBits(int x){
		int count = 0;
		for(int i=0;i<32;i++){
			if((x & (1<<i)) != 0)
				count++;
		}
		return count;
		
	}
	public static void main(String[] args){
		int x = 0x3;
		System.out.println(Integer.toBinaryString(-1).length());
//		int i = 1;
//		int j = 0;
//		
//		System.out.println(Integer.toBinaryString(x));
//		x = new BitTest().swapBit(x, i, j);
//		System.out.println(Integer.toBinaryString(x));
//		
//		System.out.println("");
//		System.out.println(Integer.toBinaryString(0b100 ^ (1<<2)));
		BitTest solu = new BitTest();
		
		System.out.println(solu.countSetBits(0xFF));
		System.out.println(solu.countSetBits(0b0000111));
				
//		System.out.println(Integer.toBinaryString(0xF));
//		System.out.println(Integer.toBinaryString(0xA));
//		System.out.println(Integer.toBinaryString(0x5));
//		System.out.println(Integer.toBinaryString(0xFFFFFFFF));
//		System.out.println(Integer.toBinaryString(0xA));
			
	}
}

package additional_wz;
import java.math.BigInteger;
import java.util.*;
public class ScannerTest {
	public static void main(String[] args){
		ScannerTest solu = new ScannerTest();
//		int a = 2;
//		System.out.println(solu.get(a,0));
//		System.out.println(solu.get(a, 1));
//		a = solu.set(a, 0, 1);
//		System.out.println(a);
//		a = solu.set(a,1,0);
//		System.out.println(a);
		solu.compute();		
	}
	public void compute(){		
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int Q = in.nextInt();
		BigInteger a = new BigInteger(in.next(),2);
		BigInteger b = new BigInteger(in.next(),2);
		BigInteger c = new BigInteger("0");
		StringBuilder sb = new StringBuilder();

		while(Q>0){
			String s = in.next();
			if(s.equals("set_a")){
				int index = in.nextInt();
				int value = in.nextInt();
				if(value == 0)
					a.clearBit(index);
				else
					a.setBit(index);
			}
			else if(s.equals("set_b")){
				int index = in.nextInt();
				int value = in.nextInt();
				if(value == 0)
					a.clearBit(index);
				else
					a.setBit(index);
			}
			else if(s.equals("get_c")){
				int index = in.nextInt();
				c = a.add(b);
				sb.append((c.testBit(index)==true)?1:0);						
			}
			Q--;
		}
		System.out.println(sb.toString());
		
	}
	
}

package additional_wz;
public class test {
	public void test(){
		int[] A = new int[1];
		test_rec(0,0);
		
	}
	private void test_rec(int A, int index){
		if(index > 5) return;
		A = index;
		System.out.println("Before index = "+ index + ", A[0] = " + A);
		test_rec(A,index+1);
		System.out.println("After index = "+ index + ", A[0] = " + A);
	}
	public static void main(String[] args){
		new test().test();
	}
}

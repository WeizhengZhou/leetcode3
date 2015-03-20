package zz;

public class StringBuilderTester {
	private void test_insert_head(int n){
		long startTime = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++){
			sb.insert(0, 'a');
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time passed  = " + (endTime - startTime));
	}
	private void test_append_tail(int n){
		long startTime = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++){
			sb.append('a');
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time passed  = " + (endTime - startTime));
	}
	public static void main(String[] args){
		StringBuilderTester solu = new StringBuilderTester();
		for(int n=100;n<=(int) 1E5;n=n*10){
			System.out.print("n = " + n + ",  ");
			solu.test_insert_head(n);
		}	
		
		for(int n=100;n<=(int) 1E5;n=n*10){
			System.out.print("n = " + n + ",  ");
			solu.test_append_tail(n);;
		}
	}
}

package additional;

public class Fib {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fib f=new Fib();
		System.out.println(f.getFibMatrix(10));
	}
	
	public long getFibMatrix(int N){
		if(N<=2){
			return 1;
		}
		long[][][] base=new long[32][2][2];
		base[0][0][0]=1;
		base[0][0][1]=1;
		base[0][1][0]=1;
		for(int i=1; i<32; i++){
			base[i]=mul(base[i-1],base[i-1]);
		}
		long[][] res=new long[2][2];
		res[0][0]=1;
		res[1][1]=1;
		for(int i=0; i<32; i++){
			if(((N-2)&(1<<i))!=0){
				res=mul(res,base[i]);
			}
		}
		return res[0][0]+res[0][1];
	}

	public long[][] mul(long[][] a, long[][] b){
		long[][] r=new long[2][2];
		r[0][0]=a[0][0]*b[0][0]+a[0][1]*b[1][0];
		r[0][1]=a[0][0]*b[0][1]+a[0][1]*b[1][1];
		r[1][0]=a[1][0]*b[0][0]+a[1][1]*b[1][0];
		r[1][1]=a[1][0]*b[0][1]+a[1][1]*b[1][1];
		return r;
	}
}

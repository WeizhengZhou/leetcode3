package additional;

public class CubicRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CubicRoot c=new CubicRoot();
		System.out.println(c.getCubicRoot(9));

	}
	
	public int getCubicRoot(int n){
		return BS(0,n,n);
	}
	public int BS(int l,int r, int n){
		if(l==r){
			return l;
		}
		if(l>r){
			return 0;
		}
		int m=l+(r-l)/2;
		if(Math.pow(m, 3)<=n && Math.pow(m+1, 3)>n){
			return m;
		}
		if(Math.pow(m, 3)>n){
			return BS(l,m-1,n);
		}
		else{
			return BS(m+1,r,n);
		}
	}
}

package dp;

public class Sqrt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int sqrt(int x) {
        if(x<0){
        	return -1;
        }
        if(x==0){
        	return 0;
        }
        return search(1,x,x);
    }
    
    public int search(int l, int r, int x){
    	if(l>r){
    		return -1;
    	}
    	int m=l+(r-l)/2;
    	if(m<=x/m && (m+1)>x/(m+1)){
    		return m;
    	}
    	else if(m>x/m){
    		return search(l,m-1,x);
    	}
    	else{
    		return search(m+1,r,x);
    	}
    }
}

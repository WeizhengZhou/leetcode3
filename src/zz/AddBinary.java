package zz;

public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String addBinary(String a, String b) {
		if(a==null || b==null || a.length()==0 || b.length()==0){
			return a==null?b:a;
		}
		int aLen=a.length()-1;
		int bLen=b.length()-1;
		int carry=0;
		StringBuilder sb=new StringBuilder();
		while(aLen>=0 || bLen>=0){
			if(aLen>=0){
				carry+=a.charAt(aLen)=='1'?1:0;
				aLen--;
			}
			if(bLen>=0){
				carry+=b.charAt(bLen)=='1'?1:0;
				bLen--;
			}
			sb.insert(0, carry&1);
			carry=carry>>1;
		}
		if(carry!=0){
			sb.insert(0, carry&1);
		}
		return sb.toString();
	}

}

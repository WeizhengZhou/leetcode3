//zz reviewed

package zz;

public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String addBinary(String a, String b) {
		//zz, a.length() ==0 || b.length() will be handled in the while loop,
		//zz, so no need to check it ahead
		//zz, in addition, when a = "", b = "1", you will return "", however, "1" is expected
		if(a==null || b==null || a.length()==0 || b.length()==0){
			return a==null?b:a;
		}
		int aLen=a.length()-1;//zz, aLen is confusing, use aIndex instead
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
			sb.insert(0, carry&1);//zz, string builder's implementation under Java is a char array,
								  // I guess each time you all insert(offset = 0, value),
								// you will need O(n) time
								//you can use append, then reverse the string
			carry=carry>>1;
		}
		if(carry!=0){
			sb.insert(0, carry&1);
		}
		return sb.toString();
	}

}

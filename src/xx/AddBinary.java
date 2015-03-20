package xx;

public class AddBinary {
	public String addBinary(String a, String b) {
		if(a==null && b==null)return "0";
		if(a==null || b==null){return a==null?b:a;}
		StringBuilder res=new StringBuilder();
		int carry=0;
		int ai=a.length()-1;
		int bi=b.length()-1;
		while(ai>=0 || bi >=0){
			if(ai>=0){
				carry+=a.charAt(ai)-'0';
				ai--;
			}
			if(bi>=0){
				carry+=b.charAt(bi)-'0';
				bi--;
			}
			res.append(carry%2);
			carry/=2;
		}
		if(carry!=0){res.append(carry);}
		return res.reverse().toString();
	}
}

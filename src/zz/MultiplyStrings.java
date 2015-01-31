package zz;

public class MultiplyStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String multiply(String num1, String num2) {
        if(num1==null || num2==null || num1.length()==0 || num2.length()==0){
        	return "0";
        }
        int l1=num1.length();
        String res="0";
        for(int i=l1-1;i>=0;i--){
        	int cur=num1.charAt(i)-'0';
        	StringBuilder sb=new StringBuilder();
        	for(int j=l1-1;j>i;j--){
        		sb.append('0');
        	}
        	String resBuf=multiplyString(sb,cur,num2);
        	res=addString(resBuf,res);
        }
        return res.charAt(0)=='0'?"0":res;
    }
	
	private String multiplyString(StringBuilder buf, int multiplier, String num){
		int carry=0;
		for( int i=num.length()-1;i>=0;i--){
			int cur=num.charAt(i)-'0';
			carry+=cur*multiplier;
			buf.append(carry%10);
			carry/=10;
		}
		if(carry!=0){
			buf.append(carry);
		}
		return buf.reverse().toString();
	}
	
	private String addString(String num1, String num2){
		StringBuilder buf=new StringBuilder();
		int i1=num1.length()-1;
		int i2=num2.length()-1;
		int carry=0;
		while(i1>=0 || i2>=0){
			if (i1>=0){
				carry +=num1.charAt(i1--)-'0';
			}
			if(i2>=0){
				carry += num2.charAt(i2--)-'0';
			}
			buf.append(carry%10);
			carry/=10;
		}
		if(carry!=0){
			buf.append(carry);
		}
		return buf.reverse().toString();
	}
}

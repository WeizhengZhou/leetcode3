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
        int l2=num2.length();
        String res="0";
        for(int i=l1-1;i>=0;i--){
        	int cur=num1.charAt(i)-'0';
        	StringBuilder sb=new StringBuilder();
        	for(int j=0;j<i-1;j++){
        		sb.append('0');
        	}
        	String resBuf=multiplyString(sb,cur,num2);
        	res=addString(sb.reverse().toString(),res);
        }
        return res;
    }

	

}

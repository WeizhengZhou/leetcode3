package xx;

public class MultipyString {
	 public String multiply(String num1, String num2) {
	        if(num1==null || num1.length()==0 || num2==null || num2.length()==0)return "0";
	        String res="0";
	        for(int i=num1.length()-1;i>=0;i--){
	            StringBuilder buf=new StringBuilder();
	            for(int j=0;j<num1.length()-1-i;j++){buf.append('0');}
	            String cur=multiplyString(i,num1,num2,buf);
	            res=addString(cur,res);
	        }
	        return res.charAt(0)=='0'?"0":res;
	    }
	    private String multiplyString(int index,String num1,String num2,StringBuilder buf){
	        int n1=num1.charAt(index)-'0';
	        int carry=0;
	        for(int i=num2.length()-1;i>=0;i--){
	            int n2=num2.charAt(i)-'0';
	            carry+=n1*n2;
	            buf.append(carry%10);
	            carry/=10;
	        }
	        if(carry!=0)buf.append(carry);
	        return buf.reverse().toString();
	    }
	    private String addString(String s1,String s2){
	        int carry=0;
	        StringBuilder buf=new StringBuilder();
	        int i=s1.length()-1;
	        int j=s2.length()-1;
	        while(i>=0 || j>=0){
	            if(i>=0){carry+=s1.charAt(i)-'0';i--;}
	            if(j>=0){carry+=s2.charAt(j)-'0';j--;}
	            buf.append(carry%10);
	            carry/=10;
	        }
	        if(carry!=0)buf.append(carry);
	        return buf.reverse().toString();
	    }
}

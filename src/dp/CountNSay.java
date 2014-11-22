package dp;

public class CountNSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountNSay c=new CountNSay();
		System.out.println(c.countAndSay(2));

	}
    public String countAndSay(int n) {
    	if(n<=0){
    		return "";
    	}
        StringBuilder res=new StringBuilder();
        res.append("1");
        String last="1";
        for(int i=2;i<=n;i++){
        	res=new StringBuilder();
        	int c=last.charAt(0);
        	int len=0;
        	for(int j=0;j<last.length();j++){
        		System.out.println((char)c);
        		if(last.charAt(j)==c){
        			len++;
        		}
        		else{
        			res.append(len);
        			res.append((char)c);
        			len=1;
        			c=last.charAt(j);
        		}
        	}
        	res.append(len);
        	res.append((char)c);
        	last=res.toString();
        }
        return last;
    }

}

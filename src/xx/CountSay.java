package xx;

public class CountSay {

	public String countAndSay(int n) {
        if(n<=0)return"";
        String pre="1";
        int j=1;
        while(j<n){
            j++;
            StringBuilder buf=new StringBuilder();
            int last=pre.charAt(0)-'0';
            int count=0;
            for(int i=0;i<pre.length();i++){
                int cur=pre.charAt(i)-'0';
                if(cur!=last){
                    buf.append(count);
                    buf.append(last);
                    count=0;
                }
                count++;
                last=cur;
            }
            buf.append(count);
            buf.append(last);
            pre=buf.toString();
        }
        return pre;
    }
}

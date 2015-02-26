package xx;
import java.util.*;
public class GrayCode {
	public List<Integer> grayCode(int n) {
        List<Integer> res=new LinkedList<>();
        if(n<=0){res.add(0);return res;}
        List<StringBuilder> buf=new ArrayList<>();
        buf.add(new StringBuilder("0"));
        buf.add(new StringBuilder("1"));
        for(int i=1;i<n;i++){
            for(int j=buf.size()-1;j>=0;j--){
                StringBuilder cur=buf.get(j);
                buf.add(new StringBuilder(cur.toString()+"1"));
                cur.append("0");
            }
        }
        for(int i=0;i<buf.size();i++){
            res.add(Integer.parseInt(buf.get(i).reverse().toString(),2));
        }
        return res;
	}
}

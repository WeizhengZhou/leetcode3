package xx;

public class RestoreIP {
	public List<String> restoreIpAddresses(String s) {
	    List<String> res=new LinkedList<>();
	    if(s==null || s.length()<4 || s.length()>12)return res;
	    helper(0,0,s,res,new String[4]);
	    return res;
    }
    private void helper(int part,int index,String s,List<String> res, String[] buf){
        if(part>=4){
            if(index==s.length()){
                String ip=buildIP(buf);
                res.add(ip);
            }
            return;
        }
        if(s.length()-index<(4-part) ||s.length()-index>(4-part)*3){return;}
        for(int i=index;i<Math.min(index+3,s.length());i++){
            int value=Integer.parseInt(s.substring(index,i+1));
            if(value>255) break;
            buf[part]=s.substring(index,i+1);
            helper(part+1,i+1,s,res,buf);
            if(value==0){break;}
        }
    }
    private String buildIP(String[] A){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<A.length;i++){
            sb.append(A[i]);
            sb.append(".");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}

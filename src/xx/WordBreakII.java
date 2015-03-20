package xx;

public class WordBreakII {
	 public List<String> wordBreak(String s, Set<String> dict) {
	        List<String> res=new LinkedList<>();
	        if(s==null || s.length()==0) return res;
	        boolean[] isBreakable=new boolean[s.length()+1];
	        isBreakable[0]=true;
	        for(int i=1;i<s.length();i++){
	            for(int j=0;j<i;j++){
	                if(isBreakable[j]&&dict.contains(s.substring(j,i))){
	                    isBreakable[i]=true;
	                    break;
	                }
	            }
	        }
	        buildRes(s.length()-1,s,dict,isBreakable,res,new LinkedList<String>());
	        return res;
	    }
	    private void buildRes(int index,String s,Set<String> dict, boolean[] A, List<String> res,List<String> buf){
	        if(index<0){
	            StringBuilder sb=new StringBuilder();
	            for(int i=0;i<buf.size();i++){
	                sb.append(buf.get(i));
	                sb.append(" ");
	            }
	            res.add(sb.toString().trim());
	            return;
	        }
	        for(int i=0;i<=index;i++){
	            if(A[i]&&dict.contains(s.substring(i,index+1))){
	                buf.add(0,s.substring(i,index+1));
	                buildRes(i-1,s,dict,A,res,buf);
	                buf.remove(0);
	            }
	        }
	    }
}

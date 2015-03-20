package xx;

public class PalindromePartition {
	 public List<List<String>> partition(String s) {
	        List<List<String>> res=new LinkedList<>();
	        if(s==null || s.length()==0){return res;}
	        int len=s.length();
	        boolean[][] isPa=new boolean[len][len];
	        for(int i=0;i<len-1;i++){
	            isPa[i][i]=true;
	            isPa[i][i+1]=s.charAt(i)==s.charAt(i+1);
	        }
	        isPa[len-1][len-1]=true;
	        for(int d=2;d<len;d++){
	            for(int i=0;i<len-d;i++){
	                int j=i+d;
	                isPa[i][j]=isPa[i+1][j-1]&&s.charAt(i)==s.charAt(j);
	            }
	        }
	        helper(0,new LinkedList<String>(),s,isPa,res);
	        return res;
	    }
	    
	    private void helper(int index,List<String> buf,String s,boolean[][] isPa,List<List<String>> res){
	        if(index>=s.length()){
	            res.add(new LinkedList<String>(buf));
	            return;
	        }
	        for(int i=index;i<s.length();i++){
	            if(isPa[index][i]){
	                buf.add(s.substring(index,i+1));
	                helper(i+1,buf,s,isPa,res);
	                buf.remove(buf.size()-1);
	            }
	        }
	    }
}

package xx;

public class GenerateParenthesis {
	public List<String> generateParenthesis(int n) {
        List<String> res=new LinkedList<>();
        if(n<=0){return res;}
        helper(n,n,0,new char[2*n],res);
        return res;
	}
	private void helper(int remainLeftP,int remainRightP,int index, char[] buf,List<String> res){
	    if(remainLeftP==0 && remainRightP==0){
	        res.add(new String(buf));
	        return;
	    }
	    if(remainRightP==0){return;}
	    if(remainLeftP>0){
	        buf[index]='(';
	        helper(remainLeftP-1,remainRightP,index+1,buf,res);
	    }
	    if(remainLeftP<remainRightP){
	        buf[index]=')';
	        helper(remainLeftP,remainRightP-1,index+1,buf,res);
	    }
	}
}

package xx;

public class NQueen {
	 public List<String[]> solveNQueens(int n) {
	        List<String[]> res= new LinkedList<String[]>();
	        if(n<=0){
	        	return res;
	        }
	        build(0,n,new int[n],res);
	        return res;
	    }   
	    
	    public void build(int index,int n, int[] buf, List<String[]> res){
	    	if(index==n){
	    		res.add(buildString(buf));
	    		return;
	    	}
	    	for(int i=0;i<n;i++){
	    		if(check(index,i,n,buf)){
	    			buf[index]=i;
	    			build(index+1,n,buf,res);
	    		}
	    	}
	    }
	    
	    public String[] buildString(int[] buf){
	    	String[] list=new String[buf.length];
	    	for(int i=0;i<buf.length;i++){
	    		int cur=buf[i];
	    		StringBuffer sb=new StringBuffer();
	    		for(int j=0;j<=cur-1;j++){
	    			sb.append('.');
	    		}
	    		sb.append('Q');
	    		for(int j=cur+1;j<buf.length;j++){
	    			sb.append('.');
	    		}
	    		list[i]=sb.toString();
	    	}
	    	return list;
	    }
	    
	    public boolean check(int index, int cur, int n, int[] buf){
	    	for(int i=0;i<index;i++){
	    		int pre=buf[i];
	    		if(pre==cur){
	    			return false;
	    		}
	    		if(Math.abs(index-i)==Math.abs(pre-cur)){
	    			return false;
	    		}
	    	}
	    	return true;
	    }
}

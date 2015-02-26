package xx;

public class Combinations {
	 public List<List<Integer>> combine(int n, int k) {
		    List<List<Integer>> res=new LinkedList<>();
		    if(n<=0 || k<=0)return res;
		    helper(1,n,0,k,new int[k],res);
		    return res;
		}
		private void helper(int num,int n,int index,int k,int[] buf,List<List<Integer>> res){
		    if(index==k){
		        List<Integer> list=new LinkedList<Integer>();
		        for(int i=0;i<k;i++)list.add(buf[i]);
		        res.add(list);
		        return;}
		    if(num>n){return;}
		    helper(num+1,n,index,k,buf,res);
		    buf[index]=num;
		    helper(num+1,n,index+1,k,buf,res);
		    //buf.remove(buf.size()-1);
		}
}

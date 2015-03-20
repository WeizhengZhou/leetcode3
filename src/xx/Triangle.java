package xx;

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null || triangle.size()==0){return 0;}
        List<Integer> pre=new LinkedList<>();
        List<Integer> next=new LinkedList<>();
        int size=triangle.size();
        List<Integer> last=triangle.get(size-1);
        for(int i=0;i<last.size();i++){
            pre.add(last.get(i));
        }
        for(int i=size-2;i>=0;i--){
            List<Integer> cur=triangle.get(i);
            for(int j=0;j<pre.size()-1;j++){
                next.add(Math.min(pre.get(j),pre.get(j+1))+cur.get(j));
            }
            pre=new LinkedList<Integer>(next);
            next.clear();
        }
        return pre.get(0);
    }

	
}

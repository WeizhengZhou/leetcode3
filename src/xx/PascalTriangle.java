package xx;

public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        if(numRows<=0){return res;}
        List<Integer> pre=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        pre.add(1);
        //res.add(new LinkedList<>(pre));
        for(int i=1;i<numRows;i++){
           cur.add(1);
           for(int j=0;j<pre.size()-1;j++){
               cur.add(pre.get(j)+pre.get(j+1));
           }
           cur.add(1);
           res.add(new ArrayList<Integer>(pre));
           pre=new ArrayList<Integer>(cur);
           cur.clear();
        }
        res.add(new ArrayList<Integer>(pre));
        return res;
    }
}

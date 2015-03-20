package xx;

public class PascalTriangleII {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> pre=new ArrayList<>();
		if(rowIndex<0){return pre;}
		pre.add(1);
		List<Integer> cur=new ArrayList<>();
		for(int i=0;i<rowIndex;i++){
			cur.add(1);
			for(int j=0;j<pre.size()-1;j++){
				cur.add(pre.get(j)+pre.get(j+1));
			}
			cur.add(1);
			pre=new ArrayList<Integer>(cur);
			cur.clear();
		}
		return pre;
	}
}

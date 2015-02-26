package xx;

public class WordLadder {

	public int ladderLength(String start, String end, Set<String> dict) {
		if(dict==null||start==null || end==null || start.length()!=end.length()){
			return 0;
		}
		Set<String> visited =new HashSet<>();
		visited.add(start);
		Queue<String> curLevel=new LinkedList<>();
		curLevel.add(start);
		Queue<String> nextLevel=new LinkedList<>();
		int step=1;
		while(!curLevel.isEmpty()){
			String cur=curLevel.poll();
			List<String> next=build(cur,dict,end,visited);
			if(next.contains(end))return step+1;
			else{
				nextLevel.addAll(next);
			}
			if(curLevel.isEmpty()){
				curLevel=new LinkedList<String>(nextLevel);
				nextLevel.clear();
				step++;
			}
		}
		return 0;
	}
	private List<String> build(String cur,Set<String> dict,String end,Set<String> visited){
		List<String> res=new LinkedList<>();
		if(cur==null||cur.length()==0)return res;
		for(int i=0;i<cur.length();i++){
			String pre=cur.substring(0,i);
			String after=cur.substring(i+1);
			for(char c='a';c<='z';c++){
				String temp=pre+c+after;
				if((dict.contains(temp)||temp.equals(end))&&!visited.contains(temp)){
					visited.add(temp);
					res.add(temp);
				}

			}
		}
		return res;
	}

}

package zz;

import java.util.LinkedList;
import java.util.List;

public class InsertInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<Interval> insert(List<Interval> list, Interval x){
		List<Interval> resBuf=new LinkedList<Interval>();
		if(list==null || list.size()==0){
			resBuf.add(x);
			return resBuf;
		}
		int insertStart=Integer.MAX_VALUE;
		int insertEnd=Integer.MIN_VALUE;
		int listLen=list.size();
		int i=0;
		boolean set=false;
		for(;i<listLen;i++){
			Interval cur=list.get(i);
			if(cur.start>x.end){
				break;
			}
			if(cur.end<x.start){
				resBuf.add(cur);
			}
			else if(cur.end>=x.start){
				set=true;
				insertStart=Math.min(insertStart, Math.min(x.start, cur.start));
				insertEnd=Math.max(insertEnd, Math.max(cur.end, x.end));
			}			
		}
		if(!set){
			resBuf.add(x);			
		}
		else
		{
			resBuf.add(new Interval(insertStart,insertEnd));
		}
		resBuf.addAll(list.subList(i, list.size()));
		return resBuf;
	}
	
	 class Interval {
		      int start;
		      int end;
		      Interval() { start = 0; end = 0; }
		      Interval(int s, int e) { start = s; end = e; }
		  }
}

//zz reviewed

package zz;

import java.util.LinkedList;
import java.util.List;

public class InsertInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Math.PI);

	}
	public List<Interval> insert(List<Interval> list, Interval x){
		List<Interval> resBuf=new LinkedList<Interval>();
		if(list==null || list.size()==0){
			resBuf.add(x);
			return resBuf;
		}
		int insertStart=Integer.MAX_VALUE;//zz, although use a variable insert Interval is a good idea, see my simpler code
		int insertEnd=Integer.MIN_VALUE;
		int listLen=list.size();
		int i=0;
		boolean set=false;//zz, (set == false) equal to (i == listLen)
		for(;i<listLen;i++){
			Interval cur=list.get(i);
			//zz, when you write a if-else block, you should consider the logic
			//zz, for example, 
			//    here, you want to compare cur interval with interval x
			//    there are three possibilities
			//        1. no overlap, cur before x
	                //        2. overlap
			//        3. overlap, cur after x
			//so, first check if(cur.end < x.start)
			//the, check      else if(cur.start <= x.end)
			//then, automatically, else//cur.start > x.end
					
			if(cur.start>x.end){
				break;
			}
			if(cur.end<x.start){
				resBuf.add(cur);
			}
			else if(cur.end>=x.start){// if(a < b) else if(a >=b) ????
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

		//zz, consider my code below, the interval x, is like eating its neighbors, then being inserted
		/*
	         int i=0;
                 for( ;i<list.size();i++){
			Interval a = list.get(i);
                        if(a.end < x.start) 
				res.add(a);//interval before x.start
                        else if(a.start <= x.end){//interval overlapped with x
				x.start = Math.min(a.start,x.start);//update start
                                x.end = Math.max(a.end,x.end);//update end
			}
                        else{//interval after x.end
                                break;	
			}
		}
                res.add(x);//add x
                res.addAll(list.subList(i,list.size()));//add rest of list
                return res;
		*/
	}
	
	 class Interval {
		      int start;
		      int end;
		      Interval() { start = 0; end = 0; }
		      Interval(int s, int e) { start = s; end = e; }//zz, use this.start, this.end
		  }
}

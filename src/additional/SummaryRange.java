package additional;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
// have better O(NlogN) solution using TreeMap
public class SummaryRange {
	public static void main(String[] args) {
		SummaryRange s=new SummaryRange();
		s.addNum(1);
		List<Interval> l1=s.getIntervals();
		print(l1);
		s.addNum(3);
		List<Interval> l2=s.getIntervals();
		print(l2);
		s.addNum(7);
		List<Interval> l3=s.getIntervals();
		print(l3);
		s.addNum(2);
		List<Interval> l4=s.getIntervals();
		print(l4);
		s.addNum(6);
		List<Interval> l5=s.getIntervals();
		print(l5);
		TreeMap<Integer,Interval> tree=new TreeMap<> ();
	}
	private static void print(List<Interval> list) {
		System.out.println();
		for(Interval in:list){
			System.out.print("["+in.start+", "+in.end+"], ");
		}
	}
	class Interval {
		      int start;
		      int end;
		      Interval() { start = 0; end = 0; }
		      Interval(int s, int e) { start = s; end = e; }
	}
	List<Interval> list;
    public SummaryRange() {
    	list=new LinkedList<> ();
    }
    
    public void addNum(int val) {
        int size=list.size();
        if (size==0) {
        	list.add(new Interval(val,val));
        } else {
        	List<Interval> next=new LinkedList<Interval> ();
        	for(int i=0;i<size;i++) {
        		Interval cur=list.get(i);
        		if (val>cur.end+1) {
        			next.add(cur);
        			if (i==size-1) {
        				next.add(new Interval(val,val));
        			}
        		} else if (val==cur.end+1) {
        			cur.end=val;
        			next.add(cur);
        		} else if (val<cur.start-1) {
        			if(next.size()==0) {
        				next.add(new Interval(val,val));
        				next.add(cur);
        			} else if (next.size()>0){
        				Interval pre=next.get(next.size()-1);
        				if (pre.end<val) {
        					next.add(new Interval(val,val));            				
        				} 
        				next.add(cur);
        			}
        		} else if (val==cur.start-1) {
        			cur.start=val;
        			if(next.size()>0) {
        				Interval pre=next.get(next.size()-1);
        				if (pre.end==val) {
        					pre.end=cur.end;
        				} else {
        					next.add(cur);
        				}
        			}
        		} else {
        			next.add(cur);
        		}        		
        	}
        	
        	list=next;
        }
        
    }
    
    public List<Interval> getIntervals() {
        return list;
    }
}

package gogo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class RangeModule {
	public static void main(String[] args) {
		RangeModule r=new RangeModule();
		r.addRange(10, 20);
		r.removeRange(14, 16);
	}
    class Interval implements Comparable<Interval>{
        int start;
        int end;
        public Interval(int x, int y) {
            this.start=x;
            this.end=y;
        }
        public int compareTo(Interval other) {
            if (this.start==other.start) return this.end-other.end;
            return this.start-other.start;
        }
    }
    TreeSet<Interval> set;
    public RangeModule() {
        set=new TreeSet<Interval> ();
    }
    
    public void addRange(int left, int right) { System.out.println("Add left="+left+" ,right="+right);
        if (set.isEmpty()) {System.out.println(1);
            set.add(new Interval(left, right));System.out.println(2);
            return;
        }
        Iterator<Interval> it=set.iterator();
        int start=left;
        int end=right;
        while(it.hasNext()) {
            Interval cur=it.next();
            if (end<cur.start) {
                set.add(new Interval(start,end));
                break;
            } else if (left<=cur.end) {
                start=Math.min(left,cur.start);
                end=Math.max(right, cur.end);
                it.remove();                
            } 
        }
    }
    
    public boolean queryRange(int left, int right) { System.out.println("Query left="+left+" ,right="+right);
        Interval pre=set.lower(new Interval(left,right));
        if (pre==null) return false;
        return (pre.start<=left && right<=pre.end);
    }
    
    public void removeRange(int left, int right) { System.out.println("Remove left="+left+" ,right="+right);
        if (set.isEmpty()) return;
        Iterator<Interval> it=set.iterator();
        ArrayList<Interval> todo = new ArrayList<>();
        while(it.hasNext()) {
            Interval cur=it.next();
            if (right<cur.start) {
                break;
            }
            if (left>=cur.end) {
                continue;
            }
            boolean remove=false;
            if (cur.start<left) {
                set.add(new Interval(cur.start,left));
                remove=true;
            }
            if (right<cur.end) {
                set.add(new Interval(right, cur.end));
                remove=true;
            }
            if (remove) it.remove();
        }
        set.addAll(todo);
    }
}

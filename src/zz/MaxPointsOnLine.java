package zz;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
    @Override
    public boolean equals(Object o){
  	  Point p=(Point)o;
  	  return p.x==this.x && p.y==this.y;
    }
}

public class MaxPointsOnLine {

	
	
	private class Line{
		double slope;
        double cut;
        Line(double x,double y){
        	slope=x;
        	cut=y;
        }
        @Override
        public boolean equals(Object o){
        	Line line=(Line)o;
        	return Math.abs(line.slope-this.slope)<eps && Math.abs(line.cut-this.cut)<eps;
        }
        @Override
        public int hashCode(){
        	return Double.valueOf(slope).hashCode()*31-Double.valueOf(cut).hashCode();
        }
        public String toString(){
        	return "slope="+slope+" ,cut="+cut;
        }
	}
	
	double eps=1E-10;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point[] p=new Point[4];
		p[0]=new Point(3,10);
		p[1]=new Point(0,2);
		p[2]=new Point(0,2);
		p[3]=new Point(3,10);
		MaxPointsOnLine m=new MaxPointsOnLine();
		System.out.println(m.maxPoints(p));
	}
    public int maxPoints(Point[] points) {
        if(points==null || points.length==0){
        	return 0;
        }
        if(points.length==1){
            return 1;
        }
        Map<Line,Set<Integer>> map=new HashMap<>();
        Map<Integer,Set<Integer>> vertical=new HashMap<>();
        for(int i=0; i<points.length; i++){
        	Point cur=points[i];
        	for(int j=i+1;j<points.length;j++){
        		Point next=points[j];
        		if(cur.x==next.x){
        			Set<Integer> times=vertical.get(cur.x);
        			if(times==null){
        				Set<Integer> list=new HashSet<>();
        				list.add(i);
        				list.add(j);
        				vertical.put(cur.x, list);
        			}
        			else{
        				if(!times.contains(j)){
        					times.add(j);
        				}
        				if(!times.contains(i))
        				{
        					times.add(i);       				
        				}
        				vertical.put(cur.x, times);
        			}
        		}
        		else{
        			double slope=(next.y-cur.y)/1.0/(next.x-cur.x);
        			double cut=cur.y-slope*cur.x;
        			Line line=new Line(slope,cut);
        			Set<Integer> times=map.get(line);
        			if(times==null){
        				Set<Integer> list=new HashSet<>();
        				list.add(i);
        				list.add(j);
        				map.put(line, list);
        			}
        			else{
        				if(!times.contains(j))
        				{
        					times.add(j);       				
        				}
        				if(!times.contains(i))
        				{
        					times.add(i);       				
        				}
        				map.put(line, times);
        			}
        		}
        	}
        }
        int maxNpoints=0;
        for(Line l:map.keySet()){
        	maxNpoints=Math.max(maxNpoints, map.get(l).size());
        	System.out.println(l.toString());
        }
        for(Integer l:vertical.keySet()){
        	maxNpoints=Math.max(maxNpoints, vertical.get(l).size());
        }
        return maxNpoints;
    }

}

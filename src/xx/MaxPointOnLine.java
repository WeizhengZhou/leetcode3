package xx;

import java.util.*;

public class MaxPointOnLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a = -0.0;
		double b = 0.0;
		//System.out.println(Double.toHexString(a));
		//System.out.println(Double.toHexString(b));
		System.out.println(Double.valueOf(a).hashCode());
		System.out.println(Double.valueOf(b).hashCode());
		Point[] points=new Point[]{new Point(0,0),new Point(1,1),new Point(0,0)};
		MaxPointOnLine m=new MaxPointOnLine();
		System.out.println(m.maxPoints(points));
		

	}
	
	private class Line{
		double slope;
		double cut;
		public Line(double x, double y){
		slope=x;
		cut=y;
	}
	public Line(Point x, Point y){
		slope=getSlope(x,y);
		cut=getCut(x,y);
	}
	private double getSlope(Point p1, Point p2){
		if(p1.x==p2.x){return Double.MAX_VALUE;}
		else{
		return (p1.y-p2.y)/1.0/(p1.x-p2.x);
	}
	}
	private double getCut(Point p1, Point p2){
		if(p1.x==p2.x){return p1.x;}
		else{
		return (p1.y*p2.x-p2.y*p1.x)/1.0/(p2.x-p1.x);
	}
	}
	double eps=1e-7;
	public boolean equals(Object o){
		if(o instanceof Line){
			Line other=(Line)o;
			return (Math.abs(this.slope-other.slope)<eps && Math.abs(this.cut-other.cut)<eps);
	}
	else{return false;}
	}

	public int hashCode(){
		return Double.valueOf(slope).hashCode()*31+Double.valueOf(cut).hashCode();
	}
	}


	public int maxPoints(Point[] points) {
		if(points==null || points.length==0){return 0;}
		if(points.length<=2){return points.length;}
		Map<Line,Set<Integer>> map=new HashMap<>();
		for(int i=0;i<points.length-1;i++){
		for(int j=i+1;j<points.length;j++){
			Line line=new Line(points[i],points[j]);
		Set<Integer> set=map.get(line);
		if(set==null){
		set=new HashSet<Integer>();
		map.put(line,set);
	}
	set.add(i);
	set.add(j);
	}
	}
	int maxP=0;
	for(Line l: map.keySet()){
		System.out.println("slope="+l.slope+",cut="+l.cut);
		maxP=Math.max(maxP,map.get(l).size());
	}
	return maxP;
	}

}

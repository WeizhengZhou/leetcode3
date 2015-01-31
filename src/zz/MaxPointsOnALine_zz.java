import java.util.*;


public class MaxPointsOnALine {
	
	public static void main(String[] args){
		System.out.println(new Double(-0.0));
		System.out.println(new Double(0.0));
		System.out.println("0b"+Long.toBinaryString(Double.doubleToRawLongBits(-0.0)));
		System.out.println("0b"+Long.toBinaryString(Double.doubleToRawLongBits(0.0)));
		System.out.println("Positive Infinite");
		System.out.println("0b"+Long.toBinaryString(Double.doubleToRawLongBits(Double.POSITIVE_INFINITY)));
		System.out.println("0b"+Long.toBinaryString(Double.doubleToRawLongBits(Double.NaN)));
		System.out.println(Objects.hashCode(-0.0));
		System.out.println(Objects.hashCode(0.0));
		
//		MaxPointsOnALine solu = new MaxPointsOnALine();
		
		System.out.println();
		
//		solu.test();
	}
	 public void test(){

	    	Point[] points = new Point[3];
	    	points[0] = new Point(0,0);
	    	points[1] = new Point(-1,-1);
	    	points[2] = new Point(2,2);
	    	System.out.println(maxPoints(points));
	 }
    public int maxPoints(Point[] points) {
    	if(points == null) return 0;
    	if(points.length <= 2) return points.length;
    	//build map
    	Map<Line,Set<Integer>> map = new HashMap<>();
    	for(int i=0;i<points.length;i++){
    		for(int j=i+1;j<points.length;j++){
    			Line line = new Line(points[i],points[j]);
    			Set<Integer> set = map.get(line);
    			if(set == null){
    				set = new HashSet<>();
    				map.put(line, set);
    			}
    			set.add(i);
    			set.add(j);  
    		}
    	}    	
    	//find "maxLine"
    	int maxPoints = 0;
    	for(Line line:map.keySet()){
    		maxPoints = Math.max(maxPoints, map.get(line).size());
    	}
    	return maxPoints;
    }    
}

class Point {
	      int x;
	      int y;
	      Point() { x = 0; y = 0; }
	      Point(int a, int b) { x = a; y = b; }
}
class Line {
	double slope = 0.;
	double intercept = 0.;
	public Line(double s, double i){
		this.slope = s;
		this.intercept = i;
	}
	public Line(Point a, Point b){
		this.slope = slope(a,b);
		this.intercept = intercept(a,b);		
	}
	private double slope(Point a, Point b){
    	if(a.x == b.x) return Double.POSITIVE_INFINITY;
    	else{
    		double x = (b.x - a.x);
    		double y = (b.y - a.y);
    		return y/x;
    		
    	}
    }
    private double intercept(Point a, Point b){
    	if(a.x == b.x) return a.x;
    	else{
    		double x = (b.x - a.x);
    		double y = (b.x * a.y - a.x * b.y);
    		return y/x;
    	}
    }
	@Override
	public boolean equals(Object otherObject){
		if(otherObject == null) return false;
		if(this == otherObject) return true;
		if(!(otherObject instanceof Line)) return false;
		Line other = (Line) otherObject;
		return (this.slope == other.slope) && (this.intercept == other.intercept);
	}
	@Override 
	public int 	hashCode(){
		return Objects.hash(slope+0.0,intercept+0.0);
	}
	public String toString(){
		String s = String.format("%.20f", slope); 
		String i = String.format("%.20f", intercept); 
		return "[" + s + ", " + i + "]";
	}
	
}


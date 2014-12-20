package additional;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShortestPath s=new ShortestPath();
		System.out.println(s.shortestDistance(s.new Pair(2,0), s.new Pair(2,2), new int[][]{{0,0,0,0},{0,1,1,0},{0,1,1,0},{0,0,0,0}}));

	}
	
	class Pair{
		int dx;
		int dy;
		Pair(int xx,int yy){
			dx=xx;
			dy=yy;
		}
		public String toString(){
			return "x="+dx+",y="+dy;
		}
		@Override
		public boolean equals(Object p){
			return dx==((Pair)p).dx && dy==((Pair)p).dy;
		}
	}
	
	public int shortestDistance(Pair source, Pair des, int[][] A){
		int[][] dist=new int[A.length][A[0].length];
		dist[source.dx][source.dy]=0;
		Queue<Pair> q=new LinkedList<Pair>();
		q.add(source);
		while(!q.isEmpty()){
			Pair p=q.poll();
			int x=p.dx;
			int y=p.dy;
			int d=dist[x][y];
			int d1=check(x+1,y,q,source,des,A,dist,d);
			if(d1>=0){
				return d1;
			}
			int d2=check(x-1,y,q,source,des,A,dist,d);
			if(d2>=0){
				return d2;
			}
			int d3=check(x,y+1,q,source,des,A,dist,d);
			if(d3>=0){
				return d3;
			}
			int d4=check(x,y-1,q,source,des,A,dist,d);
			if(d4>=0){
				return d4;
			}
		}
		return -1;
	}
	
	public int check(int x, int y, Queue<Pair> q, Pair source, Pair des,int[][] A, int[][] dist, int d){
		if(x==des.dx && y==des.dy){
			return d+1;
		}
		if(x<0 || x>=A.length || y<0 ||y>=A[0].length){
			return -1;
		}
		if(A[x][y]==1){
			return -1;
		}
		Pair n=new Pair(x,y);
		if(!n.equals(source) && dist[x][y]==0)
		{
			q.add(n);
			dist[x][y]=d+1;
		}		
		return -1;
	}
}

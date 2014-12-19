package additional;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ContinentDivide {

	class Pair{
		int x;
		int y;
		Pair(int xx,int yy){
			x=xx;
			y=yy;
		}
		public String toString(){
			return "x="+x+",y="+y;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContinentDivide c=new ContinentDivide();
		System.out.println(c.findDivide(new int[][]{{1,1,2},{1,5,1},{8,3,8}}).toString());

	}

	public List<Pair> findDivide(int[][] A){
		int n=A.length;
		int m=A[0].length;
		boolean[][] isPa=new boolean[n][m];
		boolean[][] isAt=new boolean[n][m];
		Queue<Pair> pa=new LinkedList<Pair>();
		Queue<Pair> at=new LinkedList<Pair>();
		for(int i=0;i<n;i++){
			isPa[i][0]=true;
			isAt[i][m-1]=true;
			pa.add(new Pair(i,0));
			at.add(new Pair(i,m-1));
		}
		for(int i=0;i<n;i++){
			isPa[n-1][i]=true;
			isAt[0][i]=true;
			pa.add(new Pair(n-1,i));
			at.add(new Pair(0,i));
		}
		bfs(A,isPa,pa);
		bfs(A,isAt,at);
		List<Pair> res=new LinkedList<Pair>();
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(isPa[i][j]&&isAt[i][j]){
					res.add(new Pair(i,j));
				}
			}
		}
		return res;
	}
	public void bfs(int[][] A, boolean[][] check, Queue<Pair> queue){
		while(!queue.isEmpty()){
			Pair pair=queue.poll();
			int x=pair.x;
			int y=pair.y;
			int v=A[x][y];
			add(x+1,y,check,A,queue,v);
			add(x-1,y,check,A,queue,v);
			add(x,y+1,check,A,queue,v);
			add(x,y-1,check,A,queue,v);
		}
	}
	
	public void add(int x, int y, boolean[][] c, int[][] A, Queue<Pair> q, int v){
		if(x>=0 && x<A.length && y>=0 && y<A[0].length){
			if(!c[x][y] && A[x][y]>v){
				c[x][y]=true;
				q.add(new Pair(x,y));
			}
		}
	}
}


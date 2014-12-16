package additional;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DistToGuards {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DistToGuards d = new DistToGuards();
		char[][] A=d.distToGuards(new char[][]{{'0','0','0'},{'B','G','G'},{'B','0','0'}});
		System.out.println(Arrays.deepToString(A));
		System.out.println((char)(1+'0'));
	}
	
	private class Pair{
		int x;
		int y;
		Pair(int xx, int yy){
			x=xx;
			y=yy;
		}
		public String toString(){
			return "x="+x+",y="+y;
		}
	}
	
	public char[][] distToGuards(char[][] A){
		if(A==null || A.length==0 || A[0].length==0){
			return A;
		}
		int n=A.length;
		int m=A[0].length;
		List<Pair> cur=new LinkedList<Pair>();
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(A[i][j]=='G'){
					cur.add(new Pair(i,j));
				}
			}
		}
		List<Pair> next=new LinkedList<Pair>();
		System.out.println(cur.toString());
		int dist=1;
		while(!cur.isEmpty()){
			Pair p=cur.remove(0);
			addNext(p.x+1,p.y,next,A,dist);
			addNext(p.x-1,p.y,next,A,dist);
			addNext(p.x,p.y-1,next,A,dist);
			addNext(p.x,p.y+1,next,A,dist);
			if(cur.isEmpty()){
				dist++;
				cur=new LinkedList<Pair>(next);
				System.out.println(next.toString());
				next.clear();
			}			
		}
		return A;
	}
	public void addNext(int x, int y, List<Pair> next, char[][] A,int dist){
		if (x<0 || x>=A.length || y<0 || y>=A[0].length){
			return;
		}
		char c=A[x][y];
		if(c=='0'){
			A[x][y]=(char)(dist+'0');
			next.add(new Pair(x,y));
		}
	}
		


}

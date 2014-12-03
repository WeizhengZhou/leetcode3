package additional;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A=new int[][]{{3,6,7},{1,3,5},{3,6,8}};
		MergeKArrays m=new MergeKArrays();
		List<Integer> res=m.mergeK(A);
		System.out.println(res.toString());

	}
	private class Node{
		int val;
		int row;
		int col;
		public Node(int v, int a,int b){
			val=v;
			row=a;
			col=b;
		}
	}
	public List<Integer> mergeK(int[][] A){
		List<Integer> res=new LinkedList<Integer>();
		if(A==null){
			return res;
		}
		int k=A.length;
		int n=A[0].length;
		Node[][] matrix=new Node[k][n];
		for(int i=0;i<k;i++){
			for(int j=0; j<n; j++){
				matrix[i][j]=new Node(A[i][j],i,j);
			}
		}
		Queue<Node> q=new PriorityQueue<Node>(k,new Comparator<Node>(){

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.val-o2.val;
			}});
		for(int i=0;i<k;i++){
			q.add(matrix[i][0]);
		}
		while(!q.isEmpty()){
			Node min=q.poll();
			res.add(min.val);
			if(min.col!=n-1){
				int i=min.row;
				int j=min.col;
				q.add(new Node(A[i][j+1],i,j+1));
			}
		}
		return res;
	}
}

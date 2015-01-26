//zz reviewed

package zz;

public class JumpGameII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//zz, write comments while writing code
	 public int jump(int[] A) {
		 if(A==null || A.length <=1){
			 return 0;
		 }
		 int step=0;//zz -> nSteps to reach end
		 int i=0;//zz, index
		 int dist=A[0];//zz, max_reachable_index_sofar
		 int next=0;//zz, max_reachable_index_next
		 while(i<=dist){//zz, while(curIndex < max_reachable_index_sofar)
			 if(i>=A.length-1){//zz, comment as curIndex out of boundary
				 return step+1;
			 }
			 next=Math.max(next, i+A[i]);//zz, comment as update next max reachable index
			 i++;//
			 if(i>dist){//zz, comment as move to next level
				 dist=next;//zz, update max_reachable_index of level
				 step++;//zz, update nSteps to reach end
				 
			 }
		 }
		 return step;
	 }
}

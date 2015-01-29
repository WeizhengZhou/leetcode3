//zz reviewed
package zz;

import java.util.Arrays;

public class PermutationSeq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationSeq p=new PermutationSeq();
		System.out.println(p.getPermutation(3, 4));

	}
	
	public String getPermutation(int n, int k) {
        if(n==0 || k==0){
        	return "";
        }
	//zz independent funciton
        int[] fact=new int[n+1];//zz why fact has length n+1, and only fact[n-1] is used?
        fact[0]=1;
        for(int i=1;i<=n;i++){
        	fact[i]=fact[i-1]*i;
        }
        System.out.println(Arrays.toString(fact));
        boolean[] used=new boolean[n+1];//zz isUsed, why used has length n+1, while there is only n elements?
        used[0]=true;
        k--;
        StringBuilder resBuf=new StringBuilder();
        for(int i=n-1;i>=0;i--){
        	int nth=k>0?k/fact[i]:0;
        	//nth=nth==0?fact[i]:nth;
        	System.out.println("nth="+nth+", i="+i);
        	k=k%fact[i];
        	//k=k==0?fact[i]:k;
        	System.out.println("k="+k);
        	resBuf.append(find(nth,used));
        }
        return resBuf.toString();
    }
	
	public int find(int nth,boolean[] used){
		int i=0;
		while(nth>=0){//zz while(i<used.length){if(nth<0) ***} is more reasonable
			      //zz this loop is more reasonable to be written in for-loop
			i++;
			if(i>=used.length-1){
				return i;
			}
			if(!used[i]){
				nth--;
			}
		}
		used[i]=true;
		return i;
	}


}

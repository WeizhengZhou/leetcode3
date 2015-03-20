package xx;

public class PermutationSeq {
	public String getPermutation(int n, int k) {
		if(n<=0){
			return "";
		}
		StringBuilder res=new StringBuilder();
		boolean[] used=new boolean[n];
		int[] factorial=new int[n];
		factorial[0]=1;
		for(int i=1;i<n;i++){
			factorial[i]=i*factorial[i-1];
		}
		k--;
		for(int i=0;i<n;i++){
			int index=k/factorial[n-1-i];
			k=k%factorial[n-1-i];
			res.append(findNext(index,used));
		}
		return res.toString();
	}

	private int findNext(int index,boolean[] used){
		int i=0;
		while(i<used.length){
			if(!used[i]){
				if(index==0){
					used[i]=true;
					return i+1;
				}
				index--;
			}
			i++;
		}
		return 0;
	}
}

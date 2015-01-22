package dp;

public class PermutationSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationSequence p=new PermutationSequence();
		System.out.println(p.getPermutation(3, 2));

	}
	
	public String getPermutation(int n, int k){
		if (n==1){
			return "1";
		}
		int[] factorial=new int[n];
		factorial[0]=1;
		for(int i=1;i<n; i++){
			factorial[i]=factorial[i-1]*(i+1);
		}
		boolean[] visited=new boolean[n];
		StringBuilder sb=new StringBuilder();
		for(int i=n-2;i>=0; i--){
			int nth=k/factorial[i];
			k=k%factorial[i];
			if(k!=0){
				nth++;
			}
			System.out.println("nth="+nth+", i="+i+",k="+k);
			
			int digit=0;
			while(nth>0){
				if(!visited[digit]){
					nth--;
				}
				digit++;
			}
			sb.append(digit);
			visited[--digit]=true;
			if(k==0){
				for(int j=n-1;j>=0;j--){
					if(!visited[j]){
						sb.append(j+1);
					}
				}
				return sb.toString();
			}
		}
		return sb.toString();
	}

}

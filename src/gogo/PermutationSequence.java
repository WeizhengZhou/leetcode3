package gogo;

public class PermutationSequence {
	public static void main(String[] args) {
		PermutationSequence p = new PermutationSequence();
		System.out.println(p.getPermutation(2, 1));
	}
	
    public String getPermutation(int n, int k) {
        if (n==0 || k==0) return "";
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i=1;i<n;i++){
        	fact[i] = i*fact[i-1];
        }
        boolean[] used = new boolean[n];
        int i = n-1; //2
        StringBuilder sb = new StringBuilder();
        while (i>=0 && k>=1) {
        	int index = (k-1)/fact[i];//0
            k=(k-1)%fact[i]+1;//1
        	i--;     	
        	find(index, sb,n,k,used);
        }
        for(int j=0;j<n;j++) {
        	if (!used[j]) {sb.append(j+1);used[j]=true;}
        }
        return sb.toString();
    }
	
	private void find(int index, StringBuilder sb, int n, int k, boolean[] used) {
		int i=0;
		while(index>=0){
			if (!used[i]) {
				index--;
			}
			i++;
		}
        used[i-1] = true;
		sb.append(i);
	}
}

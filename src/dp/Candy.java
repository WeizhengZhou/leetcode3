package dp;

public class Candy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int candy(int[] ratings) {
        if(ratings==null || ratings.length==0){
        	return 0;
        }
        int l=ratings.length;
        int[] left=new int[ratings.length];
        int[] right=new int[ratings.length];
        left[0]=1;
        for(int i=1;i<l;i++){
        	if(ratings[i]>ratings[i-1]){
        		left[i]=left[i-1]+1;
        	}
        	else{
        		left[i]=1;
        	}
        }
        right[l-1]=1;
        int sum=left[l-1];
        for(int i=l-2;i>=0;i--){
        	if(ratings[i]>ratings[i+1]){
        		right[i]=right[i+1]+1;
        	}
        	else{
        		right[i]=1;
        	}
        	sum+=Math.max(left[i], right[i]);
        }
        return sum;

    }
}

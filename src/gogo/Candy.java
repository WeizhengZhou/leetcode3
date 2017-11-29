package gogo;

public class Candy {
    public int candy(int[] ratings) {
        if (ratings==null||ratings.length==0) return 0;
        if (ratings.length==1) return 1;
        int[] candy = new int[ratings.length];
        candy[0]=1;
        for(int i=1;i<ratings.length;i++){
        	if (ratings[i]>ratings[i-1]) {
        		candy[i] = candy[i-1]+1;
        	} else {
        		candy[i] = 1;
        	}
        }
        int sum=candy[ratings.length-1];
        for(int i=ratings.length-2;i>=0;i--) {
        	if (ratings[i]>ratings[i+1] && candy[i]<=candy[i+1]) {
        		candy[i] = candy[i+1]+1;
        	}
        	sum+=candy[i];
        }
        return sum;
    }
}

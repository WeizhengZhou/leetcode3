package xx;

public class Candy {
	public int candy(int[] ratings) {
    	if(ratings==null || ratings.length==0)return 0;
    	int len=ratings.length;
    	int[] left=new int[len];
    	int[] right=new int[len];
    	left[0]=1;
    	for(int i=1;i<len;i++){
    	    if(ratings[i]>ratings[i-1]){left[i]=left[i-1]+1;}
    	    else{left[i]=1;}
    	}
    	right[len-1]=1;
    	int total=Math.max(right[len-1],left[len-1]);
    	for(int i=len-2;i>=0;i--){
    	    if(ratings[i]>ratings[i+1]){right[i]=right[i+1]+1;}
    	    else{right[i]=1;}
    	    total+=Math.max(right[i],left[i]);
    	}
    	return total;
    }
}

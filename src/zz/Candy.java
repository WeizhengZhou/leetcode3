//zz reviewd

package zz;

public class Candy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int candy(int[] ratings) {
    	int[] left=new int[ratings.length]; //zz, name it meanfully
    	int[] right=new int[ratings.length]; 
    	left[0]=1;
    	for(int i=1;i<ratings.length;i++){
    		if(ratings[i]>ratings[i-1]){
    			left[i]=left[i-1]+1;
    		}
    		else{
    			left[i]=1;
    		}
    	}
    	right[ratings.length-1]=1;
    	int sum=left[ratings.length-1];
    	for(int j=ratings.length-2;j>=0;j--){
    		if(ratings[j]>ratings[j+1]){
    			right[j]=right[j+1]+1;
    		}
    		else{
    			right[j]=1;
    		}
    		sum+=Math.max(right[j], left[j]);
    	}
    	return sum;
    }
}

package dp;

public class SearchMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchMatrix s=new SearchMatrix();
		System.out.println(s.searchMatrix(new int[][]{{1},{3}}, 3));

	}
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0]==null||matrix[0].length==0){
        	return false;
        }
        int row=rowHelper(matrix, 0, matrix.length-1, target);
        int col=-1;
        if(row!=-1)
        {
        	col=colHelper(matrix,row, 0,matrix[0].length-1,target);
        }
        System.out.println("row="+row+",col="+col);
        return col!=-1?true:false;        
    }
    
    public int rowHelper(int[][] matrix, int l,int r, int target){
    	if(l>r){
    		return -1;
    	}
    	int m=l+(r-l)/2;
    	if(target>=matrix[m][0]){
    		if(m+1<=r&&target<matrix[m+1][0]||m+1>r){
    			return m;
    		}
    		else{
    			return rowHelper(matrix,m+1,r,target);
    		}
    	}
    	else{
    		return rowHelper(matrix,l,m-1,target);
    	}
    }
    
    public int colHelper(int[][] matrix, int row, int l, int r, int target){
    	if (l>r){
    		return -1;
    	}
    	int m=l+(r-l)/2;
    	if(matrix[row][m]==target){
    		return m;
    	}
    	else if(matrix[row][m]<target){
    		return colHelper(matrix, row,m+1,r,target);
    	}
    	else{
    		return colHelper(matrix, row,l,m-1,target);
    	}
    }

}

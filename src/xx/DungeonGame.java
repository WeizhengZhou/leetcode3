package xx;

public class DungeonGame {
	public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon==null || dungeon.length==0 || dungeon[0].length==0){
        	return 0;
        }
        int n=dungeon.length;
        int m=dungeon[0].length;
        int[][] energy=new int[n][m];
        energy[n-1][m-1]=dungeon[n-1][m-1]<0?-dungeon[n-1][m-1]+1:1;
        for(int i=n-2;i>=0;i--){
            energy[i][m-1]=dungeon[i][m-1]<0?-dungeon[i][m-1]+energy[i+1][m-1]:Math.max(1,energy[i+1][m-1]-dungeon[i][m-1]);
        }
        for(int j=m-2;j>=0;j--){
            energy[n-1][j]=dungeon[n-1][j]<0?-dungeon[n-1][j]+energy[n-1][j+1]:Math.max(1,energy[n-1][j+1]-dungeon[n-1][j]);
        }
        for(int i=n-2;i>=0;i--){
            for(int j=m-2;j>=0;j--){
                int min=Math.min(energy[i+1][j],energy[i][j+1]);
                energy[i][j]=dungeon[i][j]<0?-dungeon[i][j]+min:Math.max(1,min-dungeon[i][j]);
            }
        }
        return energy[0][0];
    }
}

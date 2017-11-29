package gogo;

public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon==null || dungeon.length==0 || dungeon[0].length==0) return 0;
        int[][] health = new int[dungeon.length][dungeon[0].length];
        int last = dungeon[dungeon.length-1][dungeon[0].length-1];
        health[dungeon.length-1][dungeon[0].length-1] = last <=0 ? -last+1: 1;
        for (int i=dungeon.length-2;i>=0;i--) {
        	int cur = health[i+1][dungeon[0].length-1] - dungeon[i][dungeon[0].length-1];
        	//if (dungeon[i][dungeon[0].length-1]<0 && cur==-dungeon[i][dungeon[0].length-1]) cur++;
        	health[i][dungeon[0].length-1]= cur<0 ? 1 : cur;
        }
        for (int j=dungeon[0].length-2;j>=0;j--) {
        	int cur = health[dungeon.length-1][j+1] - dungeon[dungeon.length-1][j];
        	//if (dungeon[dungeon.length-1][j]<0 && cur==-dungeon[dungeon.length-1][j]) cur++;
        	health[dungeon.length-1][j]= cur<0 ? 1 : cur;
        }
        for (int i=dungeon.length-2;i>=0;i--) {
        	for (int j=dungeon[0].length-2;j>=0;j--) {
        		int cur = Math.min(health[i][j+1], health[i+1][j]) - dungeon[i][j];
        		//if (dungeon[i][j]<0 && cur==-dungeon[i][j]) cur++;
        		health[i][j]=cur<0 ? 1:cur;
        	}
        }
        return health[0][0]>0 ? health[0][0] : 1 ;
    }
}

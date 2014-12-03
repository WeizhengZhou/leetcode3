package array;

public class SequenceWords {
	private char[][] table = new char[][]{{'a','b','c'},
										  {'d','e','f'},
	                                      {'g','h','i'},
	                                      {'j',' ',' '}};
	public void sequence(String word){
		int fromI = 0;
		int fromJ = 0;
		int toI = 0;
		int toJ = 0;
		int k = 0;
		while(k<word.length()){
			toI = getI(word.charAt(k));
			toJ = getJ(word.charAt(k));
			System.out.println( "i = " + fromI + ", j = " + fromJ + ", go to " + ", i = " + toI + ", j = " + toJ);			
			
			if(fromI == toI && fromJ == toJ){
				k++;
				fromI = toI;
				fromJ = toJ;
				System.out.println("Select " + table[toI][toJ]);
				continue;
			}
			int move = move(fromI,fromJ,toI,toJ);			
			if(move == 1){
				fromI--;
				System.out.println("Move up");
				
			}
			else if(move == 2){
				fromI++;
				System.out.println("Move down");
			}
			else if(move == 3){
				fromJ--;
				System.out.println("Move left");
			}
			else{
				fromJ++;
				System.out.println("Move right");
			}			
		}
	}
	private int move(int fromI, int fromJ, int toI, int toJ){
		if(fromI == table.length-1) return 1;
		else if(fromI < toI) return 2;
		else if(fromI > toI) return 1;
		else if(fromJ < toJ) return 4;
		else return 3;
	}
	private int getI(char c){
		for(int i=0;i<table.length;i++){
			for(int j=0;j<table[0].length;j++){
				if(table[i][j] == c)
					return i;
			}
		}
		return -1;
	}
	private int getJ(char c){
		for(int i=0;i<table.length;i++){
			for(int j=0;j<table[0].length;j++){
				if(table[i][j] == c)
					return j;
			}
		}
		return -1;
	}
	public static void main(String[] args){
		String word = "jifc";
		SequenceWords solu = new SequenceWords();
		solu.sequence(word);	
	}
}


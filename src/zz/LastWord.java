//zz reviewed

package zz;

public class LastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int lengthOfLastWord(String s){
		if(s==null || s.length()==0){
			return 0;
		}
		s=s.trim();
		int index=s.length()-1;
		int start=0;
		int end=0;//zz, where is end variable used?
		//zz, logic
		//    lastWordEndingIndex = findLastWordEndIndex(s);
		//    lastWordStartingIndex = findLastWordStartingIndex(s, lastWordEndingIndex);
		//    if(lastWordStartingIndex <0) return 0;
		//    else return lastWordEndingIndex - lastWordStartingInex + 1;
		//
		//write functions!
		while(index>=0){//zz, why double loop?
			while(index>=0 && !isChar(index,s)){
				index--;
			}
			if(index<0){
				return 0;
			}
			start=index;
			while(index>=0 && isChar(index,s)){
				index--;
			}
			break;
			//end=Math.max(0, index);
		}
		return index<0?start+1:start-index;
	}
	
	public boolean isChar(int index,String s){//zz, function name does not reflect its fuctionality,
						  //zz, isLetter()
						  //zz, all ASCII 0-255 are chars

					          //zz, this function should have signature isLetter(char c);
						        which is more extendable and meaningful
		char c=s.charAt(index);
		return c>='a'&&c<='z'||c>='A'&&c<='Z';
	}
	

}

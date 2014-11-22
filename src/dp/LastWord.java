package dp;

public class LastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LastWord l=new LastWord();
		System.out.println(l.lengthOfLastWord("Hello world"));

	}
    public int lengthOfLastWord(String s) {
        if(s==null||s.length()==0){
        	return 0;
        }
        String t=s.trim();
        if(t.length()==0){
        	return 0;
        }
        int len=0;
        int i=t.length()-1;
        while(i>=0){
        	char c=t.charAt(i);
        	if(c==' '){
        		break;
        	}
        	if(c>='a'&&c<='z'||c>='A'&&c<='Z'){
        		len++;
        		i--;
        	}
        	else{
        		return 0;
        	}        	
        }
        return len;
    }

}

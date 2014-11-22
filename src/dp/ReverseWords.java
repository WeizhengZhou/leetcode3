package dp;

public class ReverseWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseWords r=new ReverseWords();
		System.out.println(r.reverseWords("\""+" "+"\""));

	}
    public String reverseWords(String s) {
        if(s==null||s.length()==0){
        	return "";
        }
        int i=s.length()-1;
        StringBuilder sb=new StringBuilder();
        while(i>=0){
        	while(i>=0 && s.charAt(i)==' '){
        		i--;
        	}
        	int r=i;
        	while(i>=0 && s.charAt(i)!=' '){
        		i--;
        	}
        	int l=i;
        	sb.append(s.substring(l+1, r+1));
        	sb.append(' ');
        }
        System.out.println("|"+sb.toString()+"|");
        return sb.toString().trim();
    }
}

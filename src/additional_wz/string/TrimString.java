package string;

public class TrimString {
	public String trim(String s){
		if(s == null) return null;
		StringBuilder sb = new StringBuilder();
		int j=0;
		while(j<s.length()){
			while(j<s.length() && s.charAt(j) == ' ')//skip all spaces
				j++;
			while(j<s.length() && s.charAt(j) != ' '){//copy all nonspaces letters
				sb.append(s.charAt(j++));
			}
		    sb.append(" ");
		}
		String res = sb.toString();
		if(res.charAt(res.length()-1) == ' ')
			return res.substring(0,res.length()-1);
        else
			return res;	
	}
	public static void main(String[] args){
		String s = "    Hello     World    ";
		TrimString solu = new TrimString();
		System.out.println("[" + solu.trim(s) + "]");
	}

}

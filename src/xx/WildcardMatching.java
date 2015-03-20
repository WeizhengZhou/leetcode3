package xx;

public class WildcardMatching {
	public boolean isMatch(String s, String p) {
        if(s==null || p==null ){return false;}
        int lastSI=-1;
        int lastPI=-1;
        int si=0;
        int pi=0;
        while(si<s.length()){
            char charS=s.charAt(si);
            //char charP=p.charAt(pi);
            if(pi<p.length() && charS==p.charAt(pi)){si++;pi++;}
            else if(pi<p.length() && p.charAt(pi)=='?'){si++;pi++;}
            else if(pi<p.length() && p.charAt(pi)=='*'){
                lastSI=si+1;
                lastPI=pi+1;
                pi++;
                if(pi==p.length()){return true;}
            }
            else if(lastSI!=-1){
                si=lastSI++;//i
                pi=lastPI;//?
            }
            else{ return false;}
        }
        if(si!=s.length()){return false;}
        while(pi<p.length() && p.charAt(pi)=='*'){pi++;}
        return pi==p.length();
    }
}

package xx;

public class RegularExpMatching {
	public boolean isMatch(String s, String p) {
        if(s==null || p==null){return false;}
        if(s.length()==0 && p.length()==0)return true;
        //if(s.length()==0|| p.length()==0) return false;
        return helper(0,s,0,p);
    }
    private boolean helper(int si, String s, int pi, String p){
        if(pi>=p.length()){
            return si>=s.length();
        }
        if(si>=s.length()){
            if(pi<p.length()&&p.charAt(pi)=='*'||pi+1<p.length()&&p.charAt(pi+1)=='*'){return helper(si,s,pi+1,p);}
            //if(pi+1<p.length()&&p.charAt(pi+1)=='*'){return helper(si,s,pi+2,p);}
            return false;
        }
        if(si<s.length() && (pi+1<p.length() && p.charAt(pi+1)!='*'|| pi==p.length()-1)){
            if(p.charAt(pi)==s.charAt(si) || p.charAt(pi)=='.'){
                return helper(si+1,s,pi+1,p);
            }
            else{return false;}
        }
        //int sLast=si;
        if(pi+1<p.length() && p.charAt(pi+1)=='*'){
            while(si<s.length() && (s.charAt(si)==p.charAt(pi)||p.charAt(pi)=='.')){
                if(helper(si,s,pi+2,p)){return true;}
                else{si++;}
            }
        }
        return helper(si,s,pi+2,p);
    }	
}

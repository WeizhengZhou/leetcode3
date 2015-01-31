package zz;

public class RegularExpressionMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegularExpressionMatch r=new RegularExpressionMatch();
		System.out.println(r.isMatch("aa", "a*"));
	}
	public boolean isMatch(String s, String p) {
		return Match(s,0,p,0);
	}
	
	public boolean Match(String s, int is, String p, int ip){
		int lenS=s.length();
		System.out.println(lenS);
		//System.out.println("is="+is+" ,ip="+ip);
		int lenP=p.length();
		if(ip==lenP){
			return is==lenS;
		}
		//if(is>=lenS){
		//	return false;
		//}
		if(is<lenS && (ip+1<lenP && p.charAt(ip+1)!='*'||ip==lenP-1)){
			return (p.charAt(ip)==s.charAt(is)||p.charAt(ip)=='.' )&& Match(s,is+1,p,ip+1);
		}
		while(is<lenS && (s.charAt(is)==p.charAt(ip)||p.charAt(ip)=='.')){
			System.out.println("is="+is+" ,ip="+ip);
			if(Match(s,is,p,ip+2)){
				return true;
			}
			is++;
			System.out.println("is="+is+" ,ip="+ip+",s.charAt(is)="+s.charAt(is)+",p.charAt(ip)="+p.charAt(ip));
		}
		System.out.println("is="+is+" ,ip="+ip);
		return Match(s,is,p,ip+2);
	}
}

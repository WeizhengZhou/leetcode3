package zz;

public class RegularExpressionMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegularExpressionMatch r=new RegularExpressionMatch();
		System.out.println(r.isMatch("ab", ".*c"));
	}
	public boolean isMatch1(String s, String p) {
		return Match(s,0,p,0);
	}
	/*
	public boolean isMatch(String s, String p) {
		 int lenS=s.length();
		 int lenP=p.length();
		 int is=0;
		 int ip=0;
		 int restartS=-1;
		 int restartP=-1;
		 while(is<lenS){
			 System.out.println("is="+is+" ,ip="+ip);
			 if(ip+1<lenP && (p.charAt(ip)=='.'|| p.charAt(ip)==s.charAt(is)) && p.charAt(ip+1)!='*'|| ip==lenP-1&& (p.charAt(ip)=='.'|| p.charAt(ip)==s.charAt(is))){
				 is++;
				 ip++;
				 continue;
			 }
			 if(ip+1<lenP && p.charAt(ip+1)=='*'){
				 restartS=is+1;
				 restartP=ip+2;
				 ip+=2;
				 continue;
			 }
			 if(restartP!=-1 && restartS<=lenS && restartP<=lenP && (s.charAt(restartS-1)==p.charAt(restartP-2)||p.charAt(restartP-2)=='.')){				 
				 is=restartS++;
				 ip=restartP;
				 continue;
			 }
			 return false;
		 }
		 while(ip<lenP && p.charAt(ip)=='*'){
			 ip++;
		 }
		 return ip==lenP;
	 }*/
	
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

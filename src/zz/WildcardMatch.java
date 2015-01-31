package zz;

public class WildcardMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public boolean isMatch(String s, String p) {
		 int lenS=s.length();
		 int lenP=p.length();
		 int is=0;
		 int ip=0;
		 int restartS=-1;
		 int restartP=-1;
		 while(is<lenS){
			 if(ip<lenP && (p.charAt(ip)=='?'|| p.charAt(ip)==s.charAt(is))){
				 is++;
				 ip++;
				 continue;
			 }
			 if(ip<lenP && p.charAt(ip)=='*'){
				 restartS=is+1;
				 restartP=ip+1;
				 ip++;
				 continue;
			 }
			 if(restartP!=-1){
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
	 }
}

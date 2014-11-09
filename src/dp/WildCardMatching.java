package dp;

public class WildCardMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WildCardMatching w=new WildCardMatching();
		System.out.println(w.isMatch("aa", "a"));
		System.out.println(w.isMatch("ab", "?*"));
		System.out.println(w.isMatch("aab", "a***b"));
	}

	public boolean isMatch(String s, String p){
		if (s==null&&p==null) return true;
		else if(s==null||p==null) return false;
		int[][] check=new int[s.length()+1][p.length()+1];
		for(int i=0; i<=s.length();i++){
			for(int j=0; j<=p.length();j++){
				check[i][j]=0;
			}
		}
		return helper(s,p,0,0, check)==1?true:false;
	}
	
	public int helper(String s, String p, int is, int ip, int[][] check){
		if (check[is][ip]!=0) return check[is][ip];
		
			while(is<s.length()&&ip<p.length()&&p.charAt(ip)!='*'){
				if((p.charAt(ip)==s.charAt(is)||(p.charAt(ip)=='?'&&is<s.length()))){
					is++;
					ip++;
				}
				else{
					check[is][ip]=-1;
					return -1;
				}
			}
			if (ip>=p.length()&&is>=s.length()) {
				check[is][ip]=1;
				return 1;/////
			}
			else if(ip>=p.length()||is>=s.length()) {
				check[is][ip]=-1;
				return -1;
			}

			while(ip<p.length()&&p.charAt(ip)=='*'){
				ip++;
			}
			for(int i=is;i<=s.length();i++){
				
				if(helper(s,p,i,ip,check)==1){
					check[is][ip]=1;
					return 1;
				}
			}
			check[is][ip]=-1;
			return -1;
		
	}
}

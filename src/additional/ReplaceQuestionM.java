package additional;

import java.util.LinkedList;
import java.util.List;

public class ReplaceQuestionM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReplaceQuestionM r=new ReplaceQuestionM();
		System.out.println(r.replace("a?b?c?d").toString());

	}
	
	public List<String> replace(String S){
		int N=0;
		for(int i=0;i<S.length();i++){
			if(S.charAt(i)=='?'){
				N++;
			}
		}
		int n=(int)Math.pow(2, N)-1;
		List<String> res=new LinkedList<String>();
		for(int i=0;i<=n;i++){
			String bi=Integer.toBinaryString(i);
			int l=bi.length();
			if(bi.length()<N){
				for(int k=0;k<N-l;k++){
					bi="0"+bi;
				}
			}
			//System.out.println("binary="+bi);
			int in=0;
			StringBuilder sb=new StringBuilder();
			for(int j=0;j<S.length();j++){
				if(S.charAt(j)=='?'){
					//System.out.println("S.charAt(i)="+S.charAt(j)+"in="+in);
					sb.append(bi.charAt(in));
					in++;
				}
				else{
					sb.append(S.charAt(j));
				}
			}
			res.add(sb.toString());
		}
		return res;
	}

}

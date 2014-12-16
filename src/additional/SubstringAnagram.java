package additional;

public class SubstringAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubstringAnagram s=new SubstringAnagram();
		System.out.println(s.isSubstringAnagram("abcdXYZdcd", "YXZ"));

	}
	
	public boolean isSubstringAnagram(String S, String T){
		if(S==null || T==null){
			return false;
		}
		for(int i=0; i<S.length()-T.length(); i++){
			int[] dict=getWord(T);
			int f=T.length();
			for(int j=0; j<T.length(); j++){
				char c=S.charAt(i+j);
				dict[c]--;
				if(dict[c]<0){
					break;
				}
				f--;
			}
			if(f==0)
			{
				return true;
			}
		}
		return false;
	}
	
	public int[] getWord(String T){
		int[] dict=new int[256];
		for(int i=0; i<T.length(); i++){
			char c=T.charAt(i);
			dict[c]++;
		}
		return dict;
	}

}
